//file:noinspection GrMethodMayBeStatic
package org.grails.plugins.shiro.pages

import geb.Page

class LoginPage extends Page {
    static url = '/auth/login'
    static at = {
        title == 'Login'
    }

    static content = {
        usernameField { $('#username') }
        passwordField { $('#password') }
        loginButton { $('form').find('input', type: 'submit') }
        alertMessage { $('div.alert-info') }
    }

    void login(String username, String password) {
        usernameField.value(username)
        passwordField.value(password)
        loginButton.click()
    }
}
