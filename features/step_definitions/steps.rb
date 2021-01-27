require_relative '../pages/homePage.rb'

home = HomePage.new

Given('user is on the home page') do
  sleep 20
  home.verifyHomePage()
end

And('user enter {string} code') do |user|
  sleep 5
  home.sendUser(user)
end

And('user enter {string}') do |pword|
  home.sendPin(pword)
end

And('user clicks login') do
  home.ClickLogin()
end

Then('verify ebook') do
  home.verifyEbook()
end

And('user clicks the log in with clever button') do
  home.clickLogClever()
end