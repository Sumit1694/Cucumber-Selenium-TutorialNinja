package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MyWishListPage;
import testBase.TestContextSetup;

public class myWishListPageStepDefinitions {

    TestContextSetup testContextSetup;
    MyWishListPage myWishListPage;

    public myWishListPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.myWishListPage = testContextSetup.pageObjectManger.getMyWishListPage();
        testContextSetup.log.info("MyWishListPageStepDefinitions initialized.");
    }

    @Then("Add to cart button must be disabled for out of stock product on my wishlist page")
    public void add_to_cart_button_must_be_disabled_for_out_of_stock_product_on_my_wishlist_page() {
        Assert.assertTrue(myWishListPage.validateAddToCartButtonIsDisabledForOutOfStockProduct(), "addToCart button is enabled for outofStock product!");
    }

    @Then("User cannot click on add to cart button for out of stock product, Add to cart button must be disabled")
    public void user_cannot_click_on_add_to_cart_button_for_out_of_stock_product_add_to_cart_button_must_be_disabled() {
        testContextSetup.log.info("Verifying 'Add to Cart' button is disabled for out-of-stock product.");
        Assert.assertTrue(myWishListPage.verifyAddToCartButtonIsDisabledForOutOfStockProduct(),"Add to Cart button is still enabled for out-of-stock product!");
        testContextSetup.log.info("Verified: 'Add to Cart' button is disabled for out-of-stock product.");
    }

    @When("User click add to cart button for product added in wishlist")
    public void user_click_add_to_cart_button_for_product_added_in_wishlist() {
        testContextSetup.log.info("Clicking on 'Add to Cart' button for product in wishlist.");
        myWishListPage.clickAddToCartButtonfromWishList();
        testContextSetup.log.info("Clicked on 'Add to Cart' button from wishlist successfully.");
    }

    @Then("User will see if wishList header count is getting decresed after removing products from wishlist")
    public void user_will_see_if_wish_list_header_count_is_getting_decresed_after_removing_products_from_wishlist() {
        testContextSetup.log.info("Verifying if wishlist header count decreases after removing product.");
        myWishListPage.isWishListCountDecreasedAfterRemove();
        testContextSetup.log.info("Wishlist header count verified after product removal.");
    }

    @Then("User is redirected to wishList page")
    public void user_is_redirected_to_wish_list_page() {
        testContextSetup.log.info("Verifying user redirection to wishlist page.");
        myWishListPage.isMyWishListBreadCrumbIsDisplayed();
        testContextSetup.log.info("User successfully redirected to wishlist page.");
    }

    @Then("User removes all listed products in wishList page")
    public void user_removes_all_listed_products_in_wish_list_page() {
        testContextSetup.log.info("Removing all listed products from wishlist page.");
        myWishListPage.removeAllProductsOneByOne();
        testContextSetup.log.info("All products successfully removed from wishlist.");
    }

    @Then("User must see {string} message")
    public void user_must_see_message(String emptyWishListMessage) {
        testContextSetup.log.info("Verifying empty wishlist message is displayed correctly.");
        Assert.assertEquals(myWishListPage.getEmptyWishListMessage(), emptyWishListMessage,
                "Empty wishlist message is not displaying correctly!");
        testContextSetup.log.info("Verified empty wishlist message successfully.");
    }

    @Then("User can see img of product, product name, model, stock, unit price, action buttons")
    public void user_can_see_img_of_product_product_name_model_stock_unit_price_action_buttons() {
        testContextSetup.log.info("Verifying product details (image, name, model, stock, price, actions) on wishlist page.");
        myWishListPage.isWishlistProductDetailsDisplayed();
        testContextSetup.log.info("Verified wishlist product details successfully.");
    }

    @Then("User click remove button of first product displayed in wishList page")
    public void user_click_remove_button_of_first_product_displayed_in_wish_list_page() {
        testContextSetup.log.info("Clicking remove button for first product in wishlist.");
        myWishListPage.clickRemoveButtonForFirstProductOnly();
        testContextSetup.log.info("Clicked remove button for first product successfully.");
    }

    @Then("User can see only selected product is removed and other two products are remains in the list")
    public void user_can_see_only_selected_product_is_removed_and_other_two_products_are_remains_in_the_list() {
        testContextSetup.log.info("Verifying only selected product is removed and others remain.");
        Assert.assertTrue(myWishListPage.isProductListCorrect(2),
                "After removing a product, wishlist items are not updated properly!");
        testContextSetup.log.info("Verified correct wishlist item count after removal.");
    }

    @Then("User must see single product is added to wishList page")
    public void user_must_see_single_product_is_added_to_wish_list_page() {
        testContextSetup.log.info("Verifying single product addition to wishlist without duplication.");
        Assert.assertTrue(myWishListPage.isProductNotDuplicated(), "Duplicate product found in wishlist!");
        testContextSetup.log.info("Verified wishlist contains a single unique product.");
    }

    @When("User click on Add to Cart icon option in the displayed My Wish List page")
    public void user_click_on_add_to_cart_icon_option_in_the_displayed_my_wish_list_page() {
        testContextSetup.log.info("Clicking on 'Add to Cart' icon from wishlist page.");
        myWishListPage.clickAddToCartButton();
        testContextSetup.log.info("Clicked on 'Add to Cart' icon successfully.");
    }

    @Then("User click on shopping cart header option")
    public void user_click_on_shopping_cart_header_option() {
        testContextSetup.log.info("Clicking on Shopping Cart header option.");
        myWishListPage.clickShoppingCartHeaderOption();
        testContextSetup.log.info("Clicked on Shopping Cart header successfully.");
    }

    @Then("User must see all {string} products added to wishList page")
    public void user_must_see_all_products_added_to_wish_list_page(String numberOfProducts) {
        testContextSetup.log.info("Verifying that all '{}' products are added to wishlist.", numberOfProducts);
        myWishListPage.isProductListCorrect(3);
        testContextSetup.log.info("Verified all products are added to wishlist successfully.");
    }

    @Then("User click remove button in wishList page")
    public void user_click_remove_button_in_wish_list_page() {
        testContextSetup.log.info("Clicking remove button in wishlist page.");
        myWishListPage.clickRemoveButton();
        testContextSetup.log.info("Clicked remove button successfully on wishlist page.");
    }
}
