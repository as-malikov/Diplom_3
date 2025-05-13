package pageobject;

public class AccountProfilePage {
    private String ACCOUNT_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private String imageButton = ".//*[contains(@filter, 'url(#filter0_f)')]";
    private String constructorButton = ".//*[text() = 'Конструктор']";
    private String logoutButton = ".//*[text() = 'Выход']";
}
