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
    #TODO: later I need to organize this test so that the browser does not open and close each time.

   @ui
 Scenario: I find Digital tools
   Given I hover over the "Digital" menu
   And I select the "Digital Tools" option
   Then The URL should contain "digital-tools"


  @ui
  Scenario Outline: I find Parts And Service options -- the simple options
    Given I hover over the "Parts & Service" menu
    And I select the "<submenu>" option
    Then The URL should contain "<urlPart>"
    Examples:
      | submenu           | urlPart            |
      | Owner Information | owner-information  |
      | StellarSupport™   | stellarsupport     |
      | Recalls           | recall-information |
      | Safety            | safety             |
      | Self-Repair       | repair             |

  @ui @WIP
    #TODO: I have to figure out how to handle the third layer of these options
  Scenario Outline: I find Parts And Service options -- the complex options
    Given I hover over the "Parts & Service" menu
    And I select the "<submenu>" option
    Then The URL should contain "                 "
    Examples:
      | submenu                              |
      | Parts                                |
      | Manuals & Training                   |
      | Warranty, Service & Protection Plans |
      | John Deere Connected Support™        |