require_relative '../actions/Click.rb'
require_relative '../actions/Find.rb'
require_relative '../actions/Type.rb'

class HomePage

  #Local Variables
   @@userIdField = "org.nypl.labs.OpenEbooks.app:id/authBasicUserField"
   @@PassWordId = "org.nypl.labs.OpenEbooks.app:id/authBasicPassField"
   @@logWithClever = "org.nypl.labs.OpenEbooks.app:id/authOAuthIntermediaryLogoImage"
    
   #instances of classes
   @@aFind = FindElements.new
   @@aClick = ClickElements.new
   @@aType = TypeTextClass.new
   
   def verifyHomePage
     @@aClick.clickXpath("//android.widget.FrameLayout[@content-desc='Catalog']/android.widget.ImageView")     
	   @@aFind.findId(@@userIdField)     
   end
   
   def sendUser(userid)
     @userId = userid
     @@aType.sendTypeId(@@userIdField, @userId)     
   end
   
   def sendPin(pword)
     @pword = pword
     @@aType.sendTypeId(@@PassWordId,@pword)     
   end
   
   def ClickLogin
     @@aClick.clickId("org.nypl.labs.OpenEbooks.app:id/authBasicLogin")     
   end
      
   def verifyEbook
	   @@aClick.clickXpath("//android.widget.FrameLayout[@content-desc='Catalog']/android.widget.ImageView")
   end
   
  def clickLogClever
     @@aClick.clickId(@@logWithClever)
   end
end