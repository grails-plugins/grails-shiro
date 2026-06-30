package org.grails.plugins.shiro
import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration
import org.grails.plugins.shiro.pages.MainPage
import org.grails.plugins.shiro.pages.LoginPage

/**
 * See https://grails.apache.org/docs/latest/guide/testing.html#functionalTesting and https://groovy.apache.org/geb/manual/current/
 * for more instructions on how to write functional tests with Grails and Geb.
 */
@Integration
class ShiroAppSpec extends ContainerGebSpec {

    void 'should be redirected to login page when visiting the home page'() {
        when: 'visiting the home page'
            go('/')

        then: 'redirected to the login page'
            at LoginPage
            currentUrl.endsWith('/auth/login?targetUri=%2F')
    }

    void 'correct login should lead to home page'() {
        when: 'visiting the login page'
            to LoginPage

        then: 'at the login page'
            at LoginPage

        when:
            login('demo', 'secret')

        then:
            at MainPage

        when:
         $('a.btn.btn-primary').click()

        then:
          at LoginPage
          alertMessage.text() == 'You need to log in to access the page at /.'
    }
}
