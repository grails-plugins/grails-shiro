package org.grails.plugins.shiro
import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration

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
            currentUrl.endsWith('/auth/login?targetUri=%2F')
            title == 'Login'
    }

    void 'correct login should lead to home page'() {
        when: 'visiting the login page'
            go('/auth/login')

        then: 'redirected to the login page'
            title == 'Login'

        when:
            $('#username').value('demo')
            $('#password').value('secret')
            $('form').find('input', type: 'submit').click()

        then:
            title == 'Welcome to Grails'

        when:
         $('a.btn.btn-primary').click()

        then:
          title == 'Login'
          $('div.alert-info').text() == 'You need to log in to access the page at /.'
    }
}
