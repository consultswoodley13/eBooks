require_relative 'Wait.rb'
require 'rspec'

class TypeTextClass

  @@aWait = WaitElement.new
  
  def sendTypeId(element, text)
     
    @element = element
    @text = text
    @@aWait.wait_for { $driver.find_element(:id, @element).displayed? }
    $driver.find_element(:id, @element).send_keys(@text)
    end
end