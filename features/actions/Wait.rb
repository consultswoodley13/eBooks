require 'selenium-webdriver'

class WaitElement
  
  def wait_for
    Selenium::WebDriver::Wait.new(:timeout => 60).until { yield }
  end
end