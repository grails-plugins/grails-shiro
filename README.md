[![Maven Central](https://img.shields.io/maven-central/v/org.grails.plugins/grails-shiro)](https://central.sonatype.com/artifact/org.grails.plugins/grails-shiro)
[![License](https://img.shields.io/github/license/grails-plugins/grails-shiro)](https://www.apache.org/licenses/LICENSE-2.0)
[![CI](https://github.com/grails-plugins/grails-shiro/actions/workflows/ci.yml/badge.svg)](https://github.com/grails-plugins/grails-shiro/actions/workflows/ci.yml)

# Grails Shiro plugin

## Versions

* 6.0.0 This is the latest plugin release targetting Grails 7+ and using Shiro 3.x.
* 5.0.0 This is the Grails Shiro plugin for *Grails version 5+ and Shiro 2.0.1*.
* Older released versions 3.4 and 4.4.
* Version 4.5.9 supports Grails 4 with shiro 1.13.0 not released on maven, you can download the branch and
use the ./gradlew publishToMavenLocal to install it manually

This project was derived from the Grails 2.x version
(https://github.com/pledbrook/grails-shiro).

We pretty much re-wrote the plugin for Grails 3 & 4 and to simplify the use, improve the documentation
and make it easier to maintain. There are lots of changes please check out the latest [Guide](https://grails-plugins.github.io/grails-shiro/snapshot/).

### Numbering

Since v6.0.0 we are trying to simplify versioning. The plugin version is neither tied to the Grails release nor the Apache Shiro release used. We try to follow the rules of semantic versioning.


Versions up to 5.0.0 used in general the Grails major version it supports, followed by the plugin release. e.g.

```
5.0.0 = Grails 5 plugin release 0
3.4 = Grails 3 plugin release 4
4.5.9 = Grails 4 plugin release 5.9
```

### Documentation and Source

Please find the [documentation](https://grails-plugins.github.io/grails-shiro/) on the plugin page. The source code is
hosted in [grails-plugins/grails-shiro](https://github.com/grails-plugins/grails-shiro) on github.

## Installation

To install, add this to your `build.gradle` dependencies for Grails `7+`:
```
dependencies {
    implementation project('org.grails.plugins:grails-shiro:6.0.0')
}
```


For Grails 5/6 use: 
```
//include the shiro dependency, required in Gradle 5+
['ehcache', 'core', 'spring', 'web'].each { pkg ->
        implementation("org.apache.shiro:shiro-$pkg:2.0.1") {
            exclude module: 'ejb'
            exclude module: 'jsf-api'
            exclude module: 'servlet-api'
            exclude module: 'jsp-api'
            exclude module: 'jstl'
            exclude module: 'jms'
            exclude module: 'connector-api'
            exclude module: 'ehcache-core'
            exclude module: 'slf4j-api'
            exclude module: 'commons-logging'
        }
    }
```

and this for Grails 4:

```
compile "org.grails.plugins:grails-shiro:4.4"
```

and this for Grails 3:

```
compile "org.grails.plugins:grails-shiro:3.4"
```
## Getting started

If you're implementing your security from scratch, then you can install grails-shiro as above and typing

```
grails shiro-quick-start
```

For more information see: [grails shiro-quick-start](https://grails-plugins.github.io/grails-shiro/latest/#shiro-quick-start).

This will create a ShiroWildcardDbRealm in your `grails-app/realms` directory and make a ShiroUser and
ShiroRole domain class. It will also create an AuthController to let you log in.
Check out [Wildcard DB Realm](https://grails-plugins.github.io/grails-shiro/latest/#wildcard-db-realm) for how you might populate a couple of users using Boostrap.groovy.

Now, to Control access to a Controller add an Interceptor for that controller using

```
grails create-shiro-controller-interceptor MyController
```

For details see: [create-shiro-controller-interceptor](https://grails-plugins.github.io/grails-shiro/latest/#create-shiro-controller-interceptor)
which will add [access control by convention](https://grails-plugins.github.io/grails-shiro/latest/#permission-string-conventions).

## Version change log

### version 6.0.0
* upgrade to Grails 7.x
* upgrade to Shiro 3.0.x
* upgrade to modern multi-project gradle build

### version 5.0.0

* upgrade to Grails 5.3.6
* Upgrade to Shiro 2.0.1
* upgrade Gradle

WARNING: you now need to include apache shiro in your build.gradle due to the newer versions of Gradle not pulling in
transitive deps. Quick Fix below.

```
dependencies {
 ...
// add this to dependencies to get shiro depenedencies
    ['ehcache', 'core', 'spring', 'web'].each { pkg ->
        implementation("org.apache.shiro:shiro-$pkg:$shiroVersion") {
            exclude module: 'ejb'
            exclude module: 'jsf-api'
            exclude module: 'servlet-api'
            exclude module: 'jsp-api'
            exclude module: 'jstl'
            exclude module: 'jms'
            exclude module: 'connector-api'
            exclude module: 'ehcache-core'
            exclude module: 'slf4j-api'
            exclude module: 'commons-logging'
        }
    }
}
```

### version 4.5.8

* Upgrade to shiro version 1.13.0

### version 4.4

* Upgrade shiro to version 1.7.1 fixing CVE-2020-17523

### version 3.3 & 4.3

* Fixed Annotation redirect missing context path - https://github.com/grails-plugins/grails-shiro/issues/16

WARNING: This introduces a small breaking change. Annotations now use the login and unauthorized settings not URL Mappings
to set where they redirect to.

### version 4.2

* upgrade to shiro 1.4.2

### version 4.1

* ported to Grails version 4.0.0 (thanks Peter Legen/animator013 for you help!)

### version 3.1

* Added ability to set the remember me cipherKey or the length of the randomly generated key
* Fix for onNotAuthenticated and onUnauthorized not working correctly [Can't be invoked on metaclass](https://github.com/grails-plugins/grails-shiro/pull/6)

### version 3.0

* re-write from old Grails 2 plugin see updates in the [Guide](https://grails-plugins.github.io/grails-shiro/latest/)

## Building from source

To build the plugin yourself and install it from this repo:

1. clone or fork this repo to your machine
2. run `gradle publishToMavenLocal` and that will build, test, install it to your local maven repo (`~/.m2`)
3. profit!


## Kudos

* https://github.com/pledbrook/grails-shiro/commits?author=pledbrook[Peter Ledbrook] looking after original grails shiro plugin
* https://github.com/pledbrook/grails-shiro/commits?author=yellowsnow[yellowsnow]
* https://github.com/pledbrook/grails-shiro/commits?author=apandichi[apandichi]
* https://github.com/animator013[animator013 - Peter Legen]
* https://https://github.com/chrisbitmead[Chris Bitmead] - Grails 5 and AD changes
* and https://github.com/pledbrook/grails-shiro/graphs/contributors[others] for work on the previous version of the plugin.

Thank you to everyone who provides feedback!
