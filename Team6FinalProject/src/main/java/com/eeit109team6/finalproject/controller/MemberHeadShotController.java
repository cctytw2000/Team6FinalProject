package com.eeit109team6.finalproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberHeadShot;
import com.eeit109team6.finalproject.service.IMemberHeadShotService;

@Controller
public class MemberHeadShotController {

	IMemberHeadShotService MhsService;

	@Autowired
	public void setMhsService(IMemberHeadShotService mhsService) {
		MhsService = mhsService;
	}

	// 增加照片
	@RequestMapping(value = "/member/addHeadShot", method = RequestMethod.POST)
	public String addHeadShot(@RequestParam("headshotImg") MultipartFile headshotImg, HttpSession session) {
		System.out.println("headshotImg=" + headshotImg.getOriginalFilename());
		Member mem = (Member) session.getAttribute("mem");
		MemberHeadShot mhs = new MemberHeadShot();
		mhs.setMember(mem);
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd HHmmssSSS");
		String createtime = sf.format(new Date());

		mhs.setHeadshotname(createtime + headshotImg.getOriginalFilename());

		MhsService.add(mhs);

		try {
			InputStream img = headshotImg.getInputStream();
			File file = new File("C:\\memberImages\\" + mem.getAccount() + "_" + mem.getMember_id(),
					mem.getUsername() + mem.getMember_id() + createtime + headshotImg.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buff = new byte[1024];
			int len;

			while ((len = img.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}

			fos.close();
			img.close();

		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		return "redirect:/member/PhotoList";
	}

	// 照片
	@RequestMapping(value = "/member/PhotoList", method = RequestMethod.GET)
	public String HeadShotList(HttpSession session, Model model) {
		Member mem = (Member) session.getAttribute("mem");
		ArrayList<MemberHeadShot> mhs = MhsService.findByMemberId(mem.getMember_id());
		System.out.println("mhs="+mhs.get(0).getHeadshotname());
		model.addAttribute("memberheadshots", mhs);
		return "HeadShotList";
	}
}