@wip
Feature: Reddit Automation Test
  Scenario: Automate Reddit login and subreddit actions
    Given I open "https://www.reddit.com/"
    When I log in with username "your_username" and password "your_password"
    Then I search for subreddit "sports"
    And I open the subreddit
    And I print the topmost post title
    And I toggle vote on the second or third post


