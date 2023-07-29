<a href="https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/session-configuration.html">Hibernate Official Docs</a>

SessionFactory interface

Defination :- 


SessionFactory is an interface. SessionFactory can be created by providing Configuration object, which will contain all DB related property details pulled from either hibernate.cfg.xml file or hibernate.properties file. SessionFactory is a factory for Session objects.

We can create one SessionFactory implementation per database in any application. If your application is referring to multiple databases, then you need to create one SessionFactory per database.

The SessionFactory is a heavyweight object; it is usually created during application start up and kept for later use. The SessionFactory is a thread safe object and used by all the threads of an application.

A Session is used to get a physical connection with a database. The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database. Persistent objects are saved and retrieved through a Session object.

The session objects should not be kept open for a long time because they are not usually thread safe and they should be created and destroyed them as needed. The main function of the Session is to offer, create, read, and delete operations for instances of mapped entity classes. 

<hr>
<strong>OR</strong>

The application obtains Session instances from a SessionFactory. Compared to the Session interface, this object is much less exciting.

The SessionFactory is certainly not lightweight! It's intended to be shared among many application threads. There is typically a single SessionFactory for the whole application—created during application initialization, for example. However, if your application accesses multiple databases using Hibernate, you'll need a SessionFactory for each database.

The SessionFactory caches generate SQL statements and other mapping metadata that Hibernate uses at runtime. It also holds cached data that has been read in one unit of work and may be reused in a future unit of work (only if class and collection mappings specify that this second-level cache is desirable).

<hr>

<strong>Difference between SessionFactory and Session</strong>

1. SessionFactory objects are one per application and Session objects are one per client.
2. SessionFactory is to create and manage Sessions. Session is to provide a CRUD interface for mapped classes, and also access to the more versatile Criteria API.
3. SessionFactory is thread safe where as Session is not thread safe.
4. SessionFactory is a factory class for Session objects. It is available for the whole application while a Session is only available for particular transaction.
5. Session is short-lived while SessionFactory objects are long-lived. SessionFactory provides a second level cache and Session provides a first level cache.

<hr>

<strong>
First of all, asking the difference between these interfaces doesn't make any sense. It seems like asking the difference between car manufacturing plant and car. A manufacturing plant is a place where the cars will be produced. Similarly, SessionFactory is an instance which will create Session objects.
</strong>

<hr>

<strong>
A transaction simply represents a unit of work. Generally speaking, a transaction is a set of SQL operations that need to be either executed successfully or not at all. 
</strong>
<br>

<a href = "https://www.javaguides.net/2018/12/hibernate-transaction-management-tutorial.html">Transaction notes</a>