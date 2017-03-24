package com.amazonaws.mobile.ns;

/**
 * Created by ricardo on 3/14/17.
 */

public class NSProvider {

    private static NSForgetPasswordHandler forgetPasswordHandler;
    private static NSForgetPasswordRequest forgetPasswordRequest;

    private static NSMFAHandler mfaHandler;
    private static NSMFARequest mfaRequest;

    private static NSSignUpConfirmationCodeRequest signUpConfirmationCodeRequest;
    private static NSSignUpConfirmationCodeHandler signUpConfirmationCodeHandler;

    private static NSFacebookLoginRequest facebookLoginRequest;

    private static NSSignUpRequest signUpRequest;
    private static NSSignUpHandler signUpHandler;


    private static NSSignInHandler signInHandler;
    private static NSSignInRequest signInRequest;


    public static NSForgetPasswordHandler getForgetPasswordHandler() {
        return forgetPasswordHandler;
    }

    public static void setForgetPasswordHandler(NSForgetPasswordHandler forgetPasswordHandler) {
        NSProvider.forgetPasswordHandler = forgetPasswordHandler;
    }

    public static NSForgetPasswordRequest getForgetPasswordRequest() {
        return forgetPasswordRequest;
    }

    public static void setForgetPasswordRequest(NSForgetPasswordRequest forgetPasswordRequest) {
        NSProvider.forgetPasswordRequest = forgetPasswordRequest;
    }

    public static NSSignUpRequest getSignUpRequest() {
        return signUpRequest;
    }

    public static void setSignUpRequest(NSSignUpRequest signUpRequest) {
        NSProvider.signUpRequest = signUpRequest;
    }

    public static NSMFAHandler getMfaHandler() {
        return mfaHandler;
    }

    public static void setMfaHandler(NSMFAHandler mfaHandler) {
        NSProvider.mfaHandler = mfaHandler;
    }

    public static NSMFARequest getMfaRequest() {
        return mfaRequest;
    }

    public static void setMfaRequest(NSMFARequest mfaRequest) {
        NSProvider.mfaRequest = mfaRequest;
    }

    public static NSSignUpConfirmationCodeRequest getSignUpConfirmationCodeRequest() {
        return signUpConfirmationCodeRequest;
    }

    public static void setSignUpConfirmationCodeRequest(NSSignUpConfirmationCodeRequest signUpConfirmationCodeRequest) {
        NSProvider.signUpConfirmationCodeRequest = signUpConfirmationCodeRequest;
    }

    public static void setSignUpConfirmationCodeHandler(NSSignUpConfirmationCodeHandler signUpConfirmationCodeHandler) {
        NSProvider.signUpConfirmationCodeHandler = signUpConfirmationCodeHandler;
    }

    public static NSSignUpConfirmationCodeHandler getSignUpConfirmationCodeHandler() {
        return signUpConfirmationCodeHandler;
    }

    public static void setFacebookLoginRequest(NSFacebookLoginRequest facebookLoginRequest) {
        NSProvider.facebookLoginRequest = facebookLoginRequest;
    }

    public static NSFacebookLoginRequest getFacebookLoginRequest() {
        return facebookLoginRequest;
    }

    public static NSSignUpHandler getSignUpHandler() {
        return signUpHandler;
    }

    public static void setSignUpHandler(NSSignUpHandler signUpHandler) {
        NSProvider.signUpHandler = signUpHandler;
    }

    public static NSSignInHandler getSignInHandler() {
        return signInHandler;
    }

    public static void setSignInHandler(NSSignInHandler signInHandler) {
        NSProvider.signInHandler = signInHandler;
    }

    public static NSSignInRequest getSignInRequest() {
        return signInRequest;
    }

    public static void setSignInRequest(NSSignInRequest signInRequest) {
        NSProvider.signInRequest = signInRequest;
    }
}

