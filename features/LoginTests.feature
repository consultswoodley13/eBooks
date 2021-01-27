@login
Feature: Validate Login

Background:
    Given user is on the home page

@login
Scenario: when app opens validate logged in
	And user enter "<access>" code
	And user enter "<pin>"
	And user clicks login
	Then verify ebook

	Examples:
		|access     |pin  |
		|E55SKFYYTP |2825 |
#		|EMNK6TDG4R |5859 |
#		|MX8GNTIL6I |1392 |

	
#@login @teacher
#Scenario Outline: When teacher logs in
#	And user clicks the log in with clever button

#Examples:
#	|studentid|studentpword|
#	|44628|44628|
#	|48338|48338|

#@login @student
#Scenario Outline: When student logs in
#	And user clicks the log in with clever button

#	Examples:
#	|teacherid|teacherpword|
#	|418|418|
#	|364|364|
 	