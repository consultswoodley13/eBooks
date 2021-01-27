require_relative 'Wait.rb'
require 'rspec'

class ClickElements
  
  @@aWait = WaitElement.new
  
  def tempclickXpath(element)
    @element = element
    @@aWait.wait_for { $driver.find_element(:xpath, @element).displayed? } 
    $driver.find_element(:xpath, @element).click
  end
  
  def clickXpath(element)
    @element = element
    @@aWait.wait_for { $driver.find_element(:xpath, @element).displayed? } 
    $driver.find_element(:xpath, @element).click
  end
  
  def clickId(element)
    @element = element
    @@aWait.wait_for { $driver.find_element(:id, @element).displayed? } 
    $driver.find_element(:id, @element).click
  end
end