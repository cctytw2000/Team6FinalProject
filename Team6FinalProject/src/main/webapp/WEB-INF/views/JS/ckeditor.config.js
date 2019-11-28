var ckeditorConfig = {
	"fontSize": {
            "options": [
            	9,
                11,
                13,
                "default",
                17,
                19,
                21
            ]
        },
     "fontColor": {
            "colors": [
                {
                    "color": 'hsl(0, 0%, 0%)',
                    "label": 'Black'
                },
                {
                    "color": '#ff0000',
                    "label": 'red'
                },
                {
                    "color": '#ffff00',
                    "label": 'yellow'
                },
                {
                    "color": '#0066ff',
                    "label": 'blue'
                },
                {
                    "color": 'hsl(0, 0%, 100%)',
                    "label": 'White',
                    "hasBorder": "true"
                }
            ]
        },
        "fontBackgroundColor": {
            "colors": [
                {
                    "color": 'hsl(0, 75%, 60%)',
                    "label": 'Red'
                },
                {
                    "color": 'hsl(30, 75%, 60%)',
                    "label": 'Orange'
                },
                {
                    "color": 'hsl(60, 75%, 60%)',
                    "label": 'Yellow'
                },
                {
                    "color": 'hsl(90, 75%, 60%)',
                    "label": 'Light green'
                },
                {
                    "color": 'hsl(120, 75%, 60%)',
                    "label": 'Green'
                },
            ]
        },
        "highlight": {
            "options": [
                {
                    "model": 'greenMarker',
                    "class": 'marker-green',
                    "title": 'Green marker',
                    "color": 'var(--ck-highlight-marker-green)',
                    "type": 'marker'
                },
                {
                    "model": 'redPen',
                    "class": 'pen-red',
                    "title": 'Red pen',
                    "color": 'var(--ck-highlight-pen-red)',
                    "type": 'pen'
                },
                {
                    "model": 'yellowMarker',
                    "class": 'marker-yellow',
                    "title": 'Yellow marker',
                    "color": 'var(--ck-highlight-marker-yellow)',
                    "type": 'marker'
                },
            ]
        },
        alignment: {
            options: [ 'left', 'right','center','justify' ]
        },
		"toolbar": [
	        "heading", 
	        "|", 
	        "bold", 
	        "italic", 
	        "underline", 
	        'strikethrough',
	        "|",
	        'outdent',
	        'indent',
	        "|",
	        'fontSize',
	        'fontColor', 
	        'fontBackgroundColor',
	        'highlight',
	        "|",
	        'horizontalLine',
	        "alignment", 
	        "|", 
	        "link",
	        "|",
	        'removeFormat',
	        "undo", 
	        "redo"
	    ]
}