package com.pshared.steps;



import com.microsoft.playwright.*;
import io.cucumber.java.en.*;

public class RedditStepDefinitions {
    Playwright playwright;
    Browser browser;
    Page page;

    @Given("I open {string}")
    public void iOpen(String url) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate(url);
    }

    @When("I log in with username {string} and password {string}")
    public void iLogIn(String username, String password) {
        page.locator("text=Log In").click();
        page.locator("input[name='username']").fill(username);
        page.locator("input[name='password']").fill(password);
        page.locator("button[type='submit']").click();
    }

    @Then("I search for subreddit {string}")
    public void iSearchForSubreddit(String subreddit) {
        page.locator("input[placeholder='Search Reddit']").fill(subreddit);
        page.keyboard().press("Enter");
        page.waitForLoadState();
    }

    @And("I open the subreddit")
    public void iOpenTheSubreddit() {
        page.locator("a[href*='/r/sports']").click();
    }

    @And("I print the topmost post title")
    public void iPrintTheTopmostPostTitle() {
        String title = page.locator("div[data-testid='post-container']").first().locator("h3").textContent();
        System.out.println("Topmost Post Title: " + title);
    }

    @And("I toggle vote on the second or third post")
    public void iToggleVoteOnTheSecondOrThirdPost() {
        Locator posts = page.locator("div[data-testid='post-container']");
        for (int i = 1; i <= 2; i++) {
            Locator post = posts.nth(i);
            if (post.locator("span:has-text('Sponsored')").count() == 0) {
                Locator voteButton = post.locator("button[data-testid*='vote']");
                if ("true".equals(voteButton.first().getAttribute("aria-pressed"))) {
                    voteButton.last().click(); // Downvote
                } else {
                    voteButton.first().click(); // Upvote
                }
                break;
            }
        }
    }
}

