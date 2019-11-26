package com.eeit109team6.finalproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.BoardType;
import com.eeit109team6.finalproject.model.Discussion;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.Reply;
import com.eeit109team6.finalproject.model.SubjectType;
import com.eeit109team6.finalproject.service.IBoardTypeService;
import com.eeit109team6.finalproject.service.IDiscussionService;
import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.IReplyService;
import com.eeit109team6.finalproject.service.ISubjectTypeService;

@Controller
public class DiscussionController {

	public DiscussionController() {
	}

	IDiscussionService discussionService;
	IBoardTypeService boardTypeService;
	ISubjectTypeService subjectTypeService;
	IReplyService replyService;

	IMemberService memberService;
	ServletContext context;

	@Autowired
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setDiscussionService(IDiscussionService service) {
		this.discussionService = service;
	}

	@Autowired
	public void setBoardTypeService(IBoardTypeService boardTypeService) {
		this.boardTypeService = boardTypeService;
	}

	@Autowired
	public void setSubjectTypeService(ISubjectTypeService subjectTypeService) {
		this.subjectTypeService = subjectTypeService;
	}
	
	@Autowired
	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}


	// �Q�װϥD��:�C�X�Ҧ��ݪO --> showDiscussion.jsp
	@RequestMapping("/discussion")
	public String getAllBoardType(Model model, HttpServletRequest request, HttpSession session) {

//		HttpSession session = request.getSession();
		System.out.println("�i�J�����kgetAllBoardType()�A�Y�N�ɦV����showDiscussion");
		
//		Member mem = (Member) session.getAttribute("mem");//�qSession���o�ϥΪ̷|��    //�o���Y��b�e�x�A�D�n�J���A�I�Q�װϥD���|500
//		System.out.println("Member��username:"+ mem.getUsername());
//		System.out.println("session����username:" + session.getAttribute("username"));
		// boardTypeService��@��k�VDAO���o�Ҧ��ݪO���ȡA�N��]��BoardType���A������զ�����C
		
//		System.out.println("�ϥΪ̵n�J��ip��m:"+mem.getRemoteAddr());// ���o�o���m);
//		Discussion.setIpAddress(request.getRemoteAddr());// ���o�o���m
//		
//		List<Discussion> allArticlelist = discussionService.getAllArticles();
//		List<Integer> viewsByBoardType = By;
		
		// ���o�̷s�o���T�g�峹
		List<Discussion> articlelist = discussionService.getLatestArticle();
		session.setAttribute("articleLatest", articlelist);
		
		List<BoardType> list = boardTypeService.getAllBoardType();
		System.out.println("����ݪO�C��");
		model.addAttribute(list);
		return "showDiscussion";
	}

	// ��ܥ����Q�װϩҦ��峹�C��: ����k�ȵL�ΪZ���a
//	@RequestMapping("/board")		
//	public String getAllArticles(Model model) {
//		List<Discussion> list = discussionService.getAllArticles();
//		model.addAttribute(list);//discussionList  �����w�W�r�A�h�Ϊ��󭺦r�p�g+���A���r�j�gList�C
//	return "board";
//	}

	// �i�J���w�ݪO�A��ܫ��w�ݪO���峹�C�� --> board.jsp
	@RequestMapping("/board")
	public String getArticleByBoardTypeId(@RequestParam("id") Integer boardId, Model model) {

		
		// 1.���o���w�ݪ��ݩʡA�ç�s�s���H���A��s��A�����@��
		BoardType boardType = boardTypeService.getBoardTypeById(boardId);				
		discussionService.updateBoardViews(boardId); 
		BoardType boardType2 = boardTypeService.getBoardTypeById(boardId);// �z�Lservice.getBoardTypeById��k���o�@�ӫ��w�ݪ����ݪO�W��
		
		// 2.���o���w�ݪ����Ҧ��峹
		List<Discussion> Discussionlist = discussionService.getArticleByBoardTypeId(boardId);// �z�Lservice.getArticleByBoardTypeId��k���o�Ҧ����w�ݪO�W���峹
		
		// 3.�N�ݩʩ�JSpringMVC���Ѫ�model
		model.addAttribute("DiscussionList", Discussionlist);// �N���w�ݪO�W���Ҧ��峹����A���`�Jmodel���A�ѧO�r�ꬰDiscussionList
		model.addAttribute("boardType", boardType2); // �N���w�ݪO���W�٪���A�`�Jmodel���A�ѧO�r�ꬰboardType

		// ����:  discussionList ���Y�����w�W�r�A�ȶȶǤJlist�A�h������JSP�h�H���󭺦r�p�g+���A���r�j�gList�����C
		// �Nservice��@���O���o������A�]��Spring���Ѫ�Model������model����
		// Spring���Ѫ��`�J���X�\��A�䴩List�BMap�BProperties�BSet�|�ض��X�Cref:����p48
		return "board";
	}
	
	// �i�J���w�ݪO�A��ܫ��w�ݪO���峹�C�� --> board-Rich.jsp
	@RequestMapping("/board-Rich")
	public String getArticleByBoardTypeIdRich(@RequestParam("id") Integer boardId, Model model) {

		// 1.���o���w�ݪ��ݩʡA�ç�s�s���H���A��s��A�����@��
		BoardType boardType = boardTypeService.getBoardTypeById(boardId);				
		discussionService.updateBoardViews(boardId); 
		BoardType boardType2 = boardTypeService.getBoardTypeById(boardId);// �z�Lservice.getBoardTypeById��k���o�@�ӫ��w�ݪ����ݪO�W��
		
		// for bootstrap�����o����A���o�o�����
		List<SubjectType> subjectType = subjectTypeService.getAllSubjectType();// �z�Lservice.getAllSubjectType��k���o�Ҧ��o�����

		
		// 2.���o���w�ݪ����Ҧ��峹
		List<Discussion> Discussionlist = discussionService.getArticleByBoardTypeId(boardId);// �z�Lservice.getArticleByBoardTypeId��k���o�Ҧ����w�ݪO�W���峹
		
		// 3.�N�ݩʩ�JSpringMVC���Ѫ�model
		model.addAttribute("DiscussionList", Discussionlist);// �N���w�ݪO�W���Ҧ��峹����A���`�Jmodel���A�ѧO�r�ꬰDiscussionList
		model.addAttribute("boardType", boardType2); // �N���w�ݪO���W�٪���A�`�Jmodel���A�ѧO�r�ꬰboardType
		model.addAttribute("subjectType", subjectType); // �N�����W�٪��󶰦X�A�`�Jmodel���A�ѧO�r�ꬰsubjectType

		// ����:  discussionList ���Y�����w�W�r�A�ȶȶǤJlist�A�h������JSP�h�H���󭺦r�p�g+���A���r�j�gList�����C
		// �Nservice��@���O���o������A�]��Spring���Ѫ�Model������model����
		// Spring���Ѫ��`�J���X�\��A�䴩List�BMap�BProperties�BSet�|�ض��X�Cref:����p48
		return "board-Rich";
	}
	

	// �s���峹 --> article.jsp
	@RequestMapping("/article")
	public String getArticleById(Model model, @RequestParam("id") Integer articleId) {
		System.out.println("articleId:" + articleId);

		@SuppressWarnings("unused")
		Discussion discussion = discussionService.getArticleById(articleId);
		discussionService.updateViews(articleId); 
		Discussion discussion_sessDiscussion = discussionService.getArticleById(articleId);
		
		List<Reply> list = replyService.getReplyByArticle(articleId);		
		
		model.addAttribute("discussion", discussion_sessDiscussion);
		model.addAttribute("reply", list);

		return "article";
	}

//	���ѷs�W�峹�ɪ���� --> addArticle.jsp 
	@RequestMapping(value = "/addArticle", method = RequestMethod.GET)
	public String getAddArticleForm(@RequestParam("id") Integer boardId, @RequestParam("name") String name, Model model,
			HttpServletRequest request, HttpSession session) {
		System.out.println("****************************************�i�JDiscussion Controller getAddArticleForm()");

		System.out.println("���orequest.getSession()");

		List<SubjectType> subjectType = subjectTypeService.getAllSubjectType();// �z�Lservice.getAllSubjectType��k���o�Ҧ��o�����
		System.out.println("subjectTypeService.getAllSubjectType()");

		model.addAttribute("subjectType", subjectType); // �N�����W�٪��󶰦X�A�`�Jmodel���A�ѧO�r�ꬰsubjectType

		model.addAttribute("boardId", boardId);
		model.addAttribute("boardName", name);

		// subjectTypeService��@��k�VDAO���o�Ҧ��o��������ȡA�N��]��SubjectType���A������զ�����C
		List<BoardType> list = boardTypeService.getAllBoardType();
		System.out.println("�bgetAddArticleForm()���A����ݪO�C��");
		model.addAttribute(list);
		System.out.println("model.addAttribute(list)" + list);

		return "addArticle";
	}

	// �s�W�峹 -->���w�V�ܩ��ݪ��Q�׬ݪO board.jsp
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String processAddArticle(@RequestParam("boardId") Integer boardId, @RequestParam("subject") String subject,
			@RequestParam("subjectTypeId") Integer subjectType, @RequestParam("body") String body,
			@RequestParam("author") String author, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("�i�JprocessAddArticle()��k");
		BoardType type = boardTypeService.getBoardTypeById(boardId);
		
		String articleBody = request.getParameter("body").replaceAll("\n", "<br>");//����B�z
		
		Member mem = (Member) session.getAttribute("mem");//�qSession���o�ϥΪ̷|��
//		System.out.println("Member��username:"+ mem.getUsername());
		//�HaddArticle.jsp�U�Կ��subjectTypeId�A�Q�����${subjectType.subjectTypeId}�ȡA�I�sDAO���o������SubjectType����
		SubjectType Stype = subjectTypeService.getSubjectTypeById(subjectType);

		System.out.println("subjectType=" + subjectType);

		// ==============�]�w�o��峹�ɶ�=======================
//		Calendar rightNow = Calendar.getInstance();
//		String createtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
//				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
//				+ ":" + rightNow.get(Calendar.SECOND);
		
		SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		  String postTimeStamp = myFmt2.format(new Date ());
		
//		// ==============/�]�w�o��峹�ɶ�=======================
		
	
		Discussion discussion = new Discussion();
		discussion.setArticleBody(articleBody); // ��J�峹
		discussion.setMember(mem); // ��J�o��̡A�޼Ƭ�Member���A������mem
		discussion.setSubject(subject); // ��J���D
		discussion.setSubjectType(Stype);// ��J�o�����
		discussion.setBoardType(type); // ��J�ݪ�
		discussion.setViews(0); // ��J�H��(�p�ƾ�)�A��l�Ȭ�0
		discussion.setIsDeleted(0); // ��J�O�_�n�R���A��l�Ȭ�0�A���Q�R��
		discussion.setPostTimeStamp(postTimeStamp);// ��J�ɶ��W

		discussionService.addArticle(discussion);
		return "redirect:/board-Rich?id=" + boardId;   // ���w�V�ܬݪO�A�d�Nkey�Ȫ��Ϊk
	}

	
	// �s�W�^�� -->���w�V�ܩ��ݪ��Q�פ峹 article.jsp
	@RequestMapping(value = "/addReply", method = RequestMethod.POST)
	public String processAddReply(@RequestParam("articleId") Integer articleId,
			@RequestParam("body") String body,
			@RequestParam("author") String author, Model model, HttpServletRequest request, HttpSession session) throws ParseException {
		System.out.println("�i�J�s�W�^�� processAddReply()��k�AarticleId:\"+articleId");
		Reply reply = new Reply();
		String replyBody = request.getParameter("body").replaceAll("\n", "<br>");//����B�z
		Member mem = (Member) session.getAttribute("mem");//�qSession���o�ϥΪ̷|��
//		System.out.println("Member��username:"+ mem.getUsername());

//		// ==============�]�w�o��峹�ɶ�=======================
//		Calendar rightNow = Calendar.getInstance();
//		String postTimeStamp = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
//				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
//				+ ":" + rightNow.get(Calendar.SECOND);
		
		SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String postTimeStamp = myFmt2.format(new Date ());
//		// ==============/�]�w�o��峹�ɶ�=======================
	

		// ===============�N�ȶ�Jreply �ݩʪ��󤧤�=====================
		Discussion discussion = discussionService.getArticleById(articleId);//�HarticleId���o�@���峹����
		reply.setDiscussion(discussion);//�N�峹�����Jreply�ݩʡC��J�峹�s���A�޼Ƭ�Discussion���A������discussion
		reply.setReplyBody(replyBody); // ��J�^�Ф�
		reply.setMember(mem); // ��J�o��̡A�޼Ƭ�Member���A������mem
		reply.setPostTimeStamp(postTimeStamp);// ��J�ɶ��W
		
		//===============�I�sReply Service�A�N�˦n��ƪ��ݩʪ���A�浹DAO�HHibernate��i��Ʈw
		replyService.addReply(reply);
		return "redirect:/article?id=" + articleId; // ���w�V�ܩ��ݤ峹�A�d�Nkey�Ȫ��Ϊk
	}
		
	// ��x:�i�J���w�ݪO�A��ܫ��w�ݪO���峹�C�� --> board-RichBack.jsp
	@RequestMapping("/board-RichBack")
	public String getArticleByBoardTypeIdRichBack(@RequestParam("id") Integer boardId, Model model) {

		// 1.���o���w�ݪ��ݩʡA�ç�s�s���H���A��s��A�����@��
		BoardType boardType = boardTypeService.getBoardTypeById(boardId);				
		discussionService.updateBoardViews(boardId); 
		BoardType boardType2 = boardTypeService.getBoardTypeById(boardId);// �z�Lservice.getBoardTypeById��k���o�@�ӫ��w�ݪ����ݪO�W��
		
		// 2.���o���w�ݪ����Ҧ��峹
		List<Discussion> discussionlist = discussionService.getArticleByBoardTypeIdBack(boardId);// �z�Lservice.getArticleByBoardTypeId��k���o�Ҧ����w�ݪO�W���峹
		
		// 3.�N�ݩʩ�JSpringMVC���Ѫ�model
		model.addAttribute("DiscussionList", discussionlist);// �N���w�ݪO�W���Ҧ��峹����A���`�Jmodel���A�ѧO�r�ꬰDiscussionList
		model.addAttribute("boardType", boardType2); // �N���w�ݪO���W�٪���A�`�Jmodel���A�ѧO�r�ꬰboardType

		return "board-RichBack";
	}
	
	// �R���ݪO -->���w�V�ܰQ�װϫ�x���� discussionBack.jsp
	@RequestMapping(value = "/physicalDeleteBoardById", method = RequestMethod.GET)
	public String physicalDeleteBoardById(@RequestParam("id") Integer boardId) {		
		boardTypeService.physicalDeleteBoardById(boardId);
		return "redirect:/discussionBack";
	}
	
	
	// ����R���峹 -->���w�V�ܩ��ݪ��ݪO board-RichBack.jsp
	@RequestMapping(value = "/physicalDeleteArticle", method = RequestMethod.GET)
	public String physicalDeleteArticleById(@RequestParam("id") Integer articleId) {
		Discussion d = discussionService.getArticleById(articleId);	//��articleId���o���w���峹��ƦC����
		Integer boardId = d.getBoardType().getBoardId();//���F�^�ݪO�A���o�ݪOid
		
		discussionService.physicalDeleteArticleById(articleId);//����u�����R��
		
		return "redirect:/board-RichBack?id=" + boardId;
	}
		
	// �n�R���峹 -->���w�V�ܩ��ݪ��ݪO board-RichBack.jsp
	@RequestMapping(value = "/deleteArticle", method = RequestMethod.GET)
	public String deleteArticleById(@RequestParam("id") Integer articleId) {
		Discussion d = discussionService.getArticleById(articleId); //��articleId���o���w���峹��ƦC����
		Integer boardId = d.getBoardType().getBoardId();//���F�^�ݪO�A���o�ݪOid
		discussionService.deleteArticleById(articleId);//����n�R��
		List<Discussion> discussion = discussionService.getArticleByBoardTypeIdBack(boardId);//�R����A�A���@����ݪO���Ҧ��峹
		return "redirect:/board-RichBack?id=" + boardId;
	}
	
	// ��_�峹 -->���w�V�ܩ��ݪ��ݪO board-RichBack.jsp
	@RequestMapping(value = "/recoverArticleById", method = RequestMethod.GET)
	public String recoverArticleById(@RequestParam("id") Integer articleId) {
		Discussion d = discussionService.getArticleById(articleId); //��articleId���o���w���峹��ƦC����
		Integer boardId = d.getBoardType().getBoardId();//���F�^�ݪO�A���o�ݪOid
		discussionService.recoverArticleById(articleId);;//�����_
		List<Discussion> discussion = discussionService.getArticleByBoardTypeIdBack(boardId);//��_��A�A���@����ݪO���Ҧ��峹
		return "redirect:/board-RichBack?id=" + boardId;
	}
	
}
