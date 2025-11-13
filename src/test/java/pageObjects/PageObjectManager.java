package pageObjects;

import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class PageObjectManager {

	public WebDriver driver;
	public HomePage homePage;
	public MyAccountPage myAccountPage;
	public RegisterPage registerPage;
	public SuccessPage successPage;
	public NewsletterSubscriptionPage newsletterSubscriptionPage;
	public LoginPage loginPage;
	public WaitUtils waitUtils;
	public ChangePasswordPage changePasswordPage;
	public LogoutPage logoutPage;
	public SearchPage searchPage;
	public ProductDisplayPage productDisplayPage;
	public ProductComparisonPage productComparisonPage;
	public SiteMapPage siteMapPage;
	public ProductCategoryPage productCategoryPage;
	public ShoppingCartPage shoppingCartPage;
    public CheckOutPage checkOutPage;
    public MyWishListPage myWishListPage;
    public DeskTopsPage deskTopPage;
    public AboutUsPage aboutUsPage;
    public EditYourInformationPage editYourInformationPage;
    public AddressBookPage addressBookPage;
    public AddAddressPage addAddressPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderInformationPage orderInformationPage;
    public AffiliateAccountPage affiliateAccountPage;
    public ContactUsPage contactUsPage;
    public OrderSuccessPage orderSuccessPage;
    public GiftCertificatePage giftCertificatePage;
    public PurchaseGiftCertificatePage purchaseGiftCertificatePage;
    public SpecialOffersPage specialOffersPage;

	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}

	public SpecialOffersPage getSpecialOffersPage()
	{
		specialOffersPage = new SpecialOffersPage(driver);
		return specialOffersPage;
	}

	public PurchaseGiftCertificatePage getPurchaseGiftCertificatePage()
	{
		purchaseGiftCertificatePage = new PurchaseGiftCertificatePage(driver);
		return purchaseGiftCertificatePage;
	}

	public GiftCertificatePage getGiftCertificatePage()
	{
		giftCertificatePage = new GiftCertificatePage(driver);
		return giftCertificatePage;
	}

	public OrderSuccessPage getOrderSuccessPage()
	{
		orderSuccessPage = new OrderSuccessPage(driver);
		return orderSuccessPage;
	}

	public ContactUsPage getContactUsPage()
	{
		contactUsPage = new ContactUsPage(driver);
		return contactUsPage;
	}

	public AffiliateAccountPage getAffiliateAccountPage()
	{
		affiliateAccountPage = new AffiliateAccountPage(driver);
		return affiliateAccountPage;
	}

	public OrderInformationPage getOrderInformationPage()
	{
		orderInformationPage = new OrderInformationPage(driver);
		return orderInformationPage;
	}

	public OrderHistoryPage getOrderHistoryPage()
	{
		orderHistoryPage = new OrderHistoryPage(driver);
		return orderHistoryPage;
	}

	public AddAddressPage getAddAddressPage()
	{
		addAddressPage = new AddAddressPage(driver);
		return addAddressPage;
	}

	public AddressBookPage getAddressBookPage()
	{
		addressBookPage = new AddressBookPage(driver);
		return addressBookPage;
	}

	public EditYourInformationPage getEditYourInformationPage()
	{
		editYourInformationPage = new EditYourInformationPage(driver);
		return editYourInformationPage;
	}

	public AboutUsPage getAboutUsPage()
	{
		aboutUsPage = new AboutUsPage(driver);
		return aboutUsPage;
	}

	public DeskTopsPage getDeskTopsPage()
	{
		deskTopPage = new DeskTopsPage(driver);
		return deskTopPage;
	}

	public MyWishListPage getMyWishListPage()
	{
		myWishListPage = new MyWishListPage(driver);
		return myWishListPage;
	}

	public CheckOutPage getCheckOutPage()
	{
		checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}

	public ShoppingCartPage getShoppingCartPage()
	{
		shoppingCartPage = new ShoppingCartPage(driver);
		return shoppingCartPage;
	}

	public ProductCategoryPage getProductCategoryPage()
	{
		productCategoryPage = new ProductCategoryPage(driver);
		return productCategoryPage;
	}

	public SiteMapPage getSiteMapPage()
	{
		siteMapPage = new SiteMapPage(driver);
		return siteMapPage;
	}

	public ProductComparisonPage getProductComparisonPage()
	{
		productComparisonPage = new ProductComparisonPage(driver);
		return productComparisonPage;
	}

	public ProductDisplayPage getProductDisplayPage()
	{
		productDisplayPage = new ProductDisplayPage(driver);
		return productDisplayPage;
	}

	public SearchPage getSearchPage()
	{
		searchPage = new SearchPage(driver);
		return searchPage;
	}

	public HomePage getHomePage()
	{
		homePage = new HomePage(driver);
		return homePage;
	}

	public MyAccountPage getMyAccountPage()
	{
		myAccountPage = new MyAccountPage(driver);
		return myAccountPage;
	}

	public RegisterPage getRegisterPage()
	{
		registerPage = new RegisterPage(driver);
		return registerPage;
	}

	public SuccessPage getsuccessPage()
	{
		successPage = new SuccessPage(driver);
		return successPage;
	}

	public NewsletterSubscriptionPage getNewsletterSubscriptionPage()
	{
		newsletterSubscriptionPage = new NewsletterSubscriptionPage(driver);
		return newsletterSubscriptionPage;
	}

	public LoginPage getLoginPage()
	{
		loginPage = new LoginPage(driver);
		return loginPage;
	}

	public ChangePasswordPage getChangePasswordPage()
	{
		changePasswordPage = new ChangePasswordPage(driver);
		return changePasswordPage;
	}

	public LogoutPage getLogoutPage()
	{
		logoutPage = new LogoutPage(driver);
		return logoutPage;
	}




}
