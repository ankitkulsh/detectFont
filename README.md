# detectFont
Detects the font attributes from PDF files.

**The version 1.1.0 release runnable JAR file takes the filename and outputs various font attributes and text associated with it in the PDF.**<br />
The font attributes that can be extracted are:
* Base Font (Font Name)
* Font Sub Type
* Font Family
* Font Point Size
* Font Weight
* **Optional Attributes:**
	* Is AllCap
  * Is ForceBold
  * Is Italic
  * Is Script
  * Is Serif
  * Is SmallCap

**The Jar file can be executed in the following way:**<br />
*java -jar detectFontWithDependencies_1.1.0 --file "C:/Users/hp/Desktop/test_pdf.pdf" --allparams true*<br />
The option *allparams* set to true returns all the optional attributes associated with the text.<br />
**The Default value of allparams is set to false.**

**The output is in the following format:**
* **Default:**
[Font Name: <*Base Font Name*>,Font Subtype:<*Font SubType*>, Font Family: <*Font Family*>,Font Size: <*Font Point Size*>,Font Weight:<*Font Weight*>]*Text*
* **With Optional Parameters (--allparams set to true):**
[Font Name: <*Base Font Name*>,Font Subtype:<*Font SubType*>, Font Family: <*Font Family*>,Font Size: <*Font Point Size*>,Font Weight:<*Font Weight*>,Is All Cap:<*isAllCap*>,Is Force Bold:<*isForceBold*>,Is Italic:<*isItalic*>,Is Script:<*isScript*>,Is Serif:<*isSerif*>,Is Small Cap:<*isSmallCap*>,Font Size:<*Font Point Size*>]*Text*

**Output Example:**
* **Default:**
[Font Name:ABCDEE+Calibri,Bold,Font Subtype:TrueType,Font Family:null,Font Size:11.04,Font Weight:700.0]Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt, magna condimentum dignissim facilisis, neque magna tristique lectus, sed porttitor massa mi sed urna. Cras tristique leo turpis, quis tempor nisl eleifend a. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus posuere sapien eu scelerisque feugiat. Nullam leo magna, feugiat sed sollicitudin sed, accumsan eu arcu. Ut vestibulum sed nisl eget euismod. Suspendisse et lorem finibus lacus egestas sollicitudin nec ut ex. Pellentesque ac risus sit amet lacus ullamcorper facilisis.<br />
[Font Name:ABCDEE+Calibri,Font Subtype:TrueType,Font Family:null,Font Size:11.04,Font Weight:400.0]Quisque fringilla sem neque, eget iaculis sem gravida sit amet. Vivamus tincidunt justo ac aliquet commodo. Vivamus porta mauris eget lorem tincidunt posuere sit amet nec lectus. Proin a lacus et neque lacinia semper a sit amet sem. Vestibulum scelerisque, neque vitae volutpat consequat, urna mi pharetra libero, ac ornare risus felis eu ante. Pellentesque eget diam eget risus vehicula mattis consequat nec sapien. Sed lobortis commodo rutrum. Donec sodales tortor pulvinar, feugiat odio et, feugiat lectus.

* **With Optional Parameters (--allparams set to true):**
[Font Name:ABCDEE+Calibri,Bold,Font Subtype:TrueType,Font Family:null,Font Size:11.04,Font Weight:700.0,Is All Cap:false,Is Force Bold:false,Is Italic:false,Is Script:false,Is Serif:false,Is Small Cap:false,Font Size:11.04]Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt, magna condimentum dignissim facilisis, neque magna tristique lectus, sed porttitor massa mi sed urna. Cras tristique leo turpis, quis tempor nisl eleifend a. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus posuere sapien eu scelerisque feugiat. Nullam leo magna, feugiat sed sollicitudin sed, accumsan eu arcu. Ut vestibulum sed nisl eget euismod. Suspendisse et lorem finibus lacus egestas sollicitudin nec ut ex. Pellentesque ac risus sit amet lacus ullamcorper facilisis.<br />
[Font Name:ABCDEE+Calibri,Font Subtype:TrueType,Font Family:null,Font Size:11.04,Font Weight:400.0,Is All Cap:false,Is Force Bold:false,Is Italic:false,Is Script:false,Is Serif:false,Is Small Cap:false,Font Size:11.04]Quisque fringilla sem neque, eget iaculis sem gravida sit amet. Vivamus tincidunt justo ac aliquet commodo. Vivamus porta mauris eget lorem tincidunt posuere sit amet nec lectus. Proin a lacus et neque lacinia semper a sit amet sem. Vestibulum scelerisque, neque vitae volutpat consequat, urna mi pharetra libero, ac ornare risus felis eu ante. Pellentesque eget diam eget risus vehicula mattis consequat nec sapien. Sed lobortis commodo rutrum. Donec sodales tortor pulvinar, feugiat odio et, feugiat lectus.
