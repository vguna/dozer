<a href="http://dozer.sf.net"><img src="http://dozer.sourceforge.net/images/dozer.png" alt="Dozer" width="58" height="42"></a>[![Build Status](https://api.travis-ci.org/vguna/dozer.png)](https://travis-ci.org/vguna/dozer)
================================

This is a fork of the original Dozer project
--------------------------------
Due to inactivity of the original project for years, this fork has been created.
It should provide a binary build of the last 5.5.1 version plus PRs/patches that have been provided over the years but have not been merged yet.
This project should mainly focus on bugfixes and smaller enhancements since we're not familiar with the code base (yet).

The original group- and artifact ids have been left intact to signal that it's just a patch version.
Different releases of this artifact just use the last official dozer version plus the suffix `-vguna-<serial>`. So the first version will be `5.5.1-vguna-1`. 

### Included PRs

Currently this version contains the following PRs:
- Fixes compatibility issues with javassist 3.18.1-GA (https://github.com/DozerMapper/dozer/pull/239)

### How to use in pom.xml

For now, this project temporarily provides its artifacts via its github page for simplicity.
Just add this repository configuration to your own pom.xml and you're good to go:

```xml
...
<repositories>
    <repository>
        <id>dozer-mvn-repo</id>
        <url>https://raw.github.com/vguna/dozer/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
...
```

Maven coordinates can be kept as is, but a different version has to be specified:

```xml
...
<properties>
	<dozer.version>5.5.1-vguna-1-SNAPSHOT</dozer.version>
</properties>
...
<dependency>
	<groupId>net.sf.dozer</groupId>
	<artifactId>dozer</artifactId>
	<version>${dozer.version}</version>
</dependency>
...
```

### Contributions

PRs are very welcome and should always contain testcases to show the actual problem and to test the provided fix.

Why Map?
--------------------------------
A mapping framework is useful in a layered architecture where you are creating layers of abstraction by encapsulating changes to particular data objects vs. propagating these objects to other layers (i.e. external service data objects, domain objects, data transfer objects, internal service data objects).

Mapping between data objects has traditionally been addressed by hand coding value object assemblers (or converters) that copy data between the objects. Most programmers will develop some sort of custom mapping framework and spend countless hours and thousands of lines of code mapping to and from their different data object.

This type of code for such conversions is rather boring to write, so why not do it automatically?


What is Dozer?
--------------------------------
Dozer is a Java Bean to Java Bean mapper that recursively copies data from one object to another, it is an open source mapping framework that is robust, generic, flexible, reusable, and configurable.

Dozer supports simple property mapping, complex type mapping, bi-directional mapping, implicit-explicit mapping, as well as recursive mapping. This includes mapping collection attributes that also need mapping at the element level.

Dozer not only supports mapping between attribute names, but also automatically converting between types. Most conversion scenarios are supported out of the box, but Dozer also allows you to specify custom conversions via XML or code-based configuration.


Getting Started
--------------------------------
Check out the [Getting Started Guide](http://dozer.sf.net/documentation/gettingstarted.html) and [Full User Guide](http://dozer.sf.net/dozer-user-guide.pdf) or [Dozer SF Site](http://dozer.sf.net) for advanced information.


Getting the Distribution
--------------------------------
If you are using Maven, simply copy-paste this dependency to your project.

    <dependency>
        <groupId>net.sf.dozer</groupId>
        <artifactId>dozer</artifactId>
        <version>5.5.1</version>
    </dependency>

Apache Ivy users can copy-paste the following line instead.

    <dependency org="net.sf.dozer" name="dozer" rev="5.5.1"/>

Simple Example
--------------------------------
    <mapping>
      <class-a>yourpackage.SourceClassName</class-a>
      <class-b>yourpackage.DestinationClassName</class-b>
        <field>
          <A>yourSourceFieldName</A>
          <B>yourDestinationFieldName</B>
        </field>
    </mapping>

    SourceClassName sourceObject = ...
    Mapper mapper = new DozerBeanMapper();
    DestinationObject destObject =
        mapper.map(sourceObject, DestinationClassName.class);
    assertTrue(destObject.getYourDestinationFieldName().equals(sourceObject.getYourSourceFieldName));
