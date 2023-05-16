Feature: Can I go to the John Deere Home Page and look?
  Background:
    Given I go to the John Deere Home Page

  @ui
 Scenario Outline: I look at the menu items
    Given I hover over the "<menuTitle>" menu
    Examples:
    |menuTitle|
    |Equipment  |
    |Finance    |
    |Parts and Services|
    |Digital           |
    |Our Company and Purpose|
    #Manually verified that submenus are visible upon hovering

  @WIP @ui
 Scenario: I find Digital tools
   Given I hover over the "Digital" menu
   And I select the "Digital Tools" option
   Then The URL should contain "digital-tools"
