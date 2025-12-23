
# WESTERN GOVERNORS UNIVERSITY D287
### Part-C
Line 19 Was changed to "The Computer Shop"
to reflect the store I am making.
### Part-D
Line 89 in "Mainscreen.html" was changed to
add a about us button. <br />
I also added a new 
" aboutPage.html" in templates so users
have a space to go to learn about the
page.<br />
In "MainScreenController", starting at
line 55, I added new class to 
return"aboutPage"

### Part-E
In BootStrapData.java, I updated the run()
method (lines 55–75) to load sample 
inventory only when both the Parts and Products 
tables are empty, ensuring existing data is not 
overwritten. 

I added the loadSampleParts() method
(90–150) to create five PC parts using 
InhousePart/OutsourcedPart, and used a Set
(95–100) to prevent duplicate parts from being added.
If a duplicate name was in the loop
(120–135), it was converted into a “multi-pack” 
part appending “(Multi-Pack)” to the name.
I also added the loadSampleProducts() method (lines 190–215)
to create/save five PC products.

### Part-F
Updated mainscreen.html with a button to buy products
(lines 87-89).
Updated AddProductController with a new function to buy
products, will put user into a success page
if product was bought if not a failure page.
(lines 177-193).
Added new Failure/Success.html pages!

### Part-G
Added  additional fields to the part entity for 
maximum and minimum inventory in part.java
(lines 32-36 & 99-110).

Added min/max sample inventory in BootStrapData.java
(lines 80-100)
Added min/max inputs to forms both
inhouse/outhouse forms.

Renamed the DB file to /computer-db-v(number).

Created files ValidInvRange.java and InvRangeValidator.java
to make a custom validation rules for min/max inventory.
Added "@ValidInvRange" in part.java (line 21)

### Part-H
Low/High inventory validation was added in 
InvRangeValidator (lines 11-47)

Product inventory validation against part minimums
in productForm.html(lines30-51 )
and AddProductController.java(Lines 75-127)

### Part-I 
Added two new Test to PartTest.java and its validator for max/min.
(Lines 10-17, 35-49, 180-220).
