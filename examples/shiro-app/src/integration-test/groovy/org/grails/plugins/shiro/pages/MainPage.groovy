package org.grails.plugins.shiro.pages

import geb.Page

class MainPage extends Page {
    static url = '/'
    static at = {
        title == 'Welcome to Grails Shiro'
    }
}
