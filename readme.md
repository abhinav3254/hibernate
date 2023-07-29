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
Transaction is used when we need to save the data to the database.
A transaction simply represents a unit of work. Generally speaking, a transaction is a set of SQL operations that need to be either executed successfully or not at all. 
</strong>
<br>

<a href = "https://www.javaguides.net/2018/12/hibernate-transaction-management-tutorial.html">Transaction notes</a>

<hr>
<strong>How to read and save data using Hibernate?</strong>
<h4>How to read data?</h4>

Hibernate provides two different methods to read data from the database:

get(): It returns a persistence object of a given class. It returns null when there is no persistence object available.
<br>
load(): It also returns a persistence object of a given class but throws an exception (objectNotFoundException) if the entity is not available in the database.

<strong>Difference between get() and load()</strong>

<table border=5>
<tr>
<th>Session.get()</th>
<th>Session.load()</th>
</tr>
<tr>
<td>It never returns a proxy object.</td>
<td>It always returns a proxy object.</td>
</tr>
<tr>
<td>It returns null when the entity is not available in the database and continues the execution.</td>
<td>It throws an exception (objectNotFoundException) when the entity is not available in the database and terminates the execution.</td>
</tr>
<tr>
<td>Eager Loading; It hits the database immediately and returns the object</td>
<td>Lazy Loading; It hits the database only when it tries to retrieve the object.</td>
</tr>

<tr>
<td>get method of hibernate session returns null if object is not found in cache as well as on database</td>
<td>load method throws ObjectNotFoundException if object is not found on cache as well as on database but never return null</td>
<tr>

<tr>
<td>use it when you are not sure that object exists in db or not</td>
<td>use it when you are sure that object exists</td>
<tr>

<tr>
<td><strong>They are used for the SELECT operation.</strong></td>
<td><strong>They are used for DELETE and UPDATE operations.</strong></td>
</tr>
</table>

<strong>get() :- </strong>
One best explaination for get() 
Assume a condition that there you have a kirana store and a customer comes to your shop and ask for something, then you will look for that thing in your shop first incase if it is not found then you will go the warehouse to find that thing.
<br>
Same here also get() will first look for cache memory if there is already data then it will not go to the database to fetch it , incase if it not found data in the cache memory then it will go to find the object in the database.
<br>
get() method put the data in the cache memory after bringing it from the database.
<br>
<img src="https://i.pinimg.com/originals/b8/cb/e3/b8cbe34a53cb1ae5b29325ef9aa1abe2.png" height=500 width=800>
<br>
<b>Let's understand this get() by this live example</b>

int id = 104;
Student studentGet = (Student) session.get(Student.class, id);
System.out.println(studentGet.toString());
		
int id = 104;
Student studentGet1 = (Student) session.get(Student.class, id);
System.out.println(studentGet1.toString());

When you run this file you can see only one time query is fired bcz hibernate calls for the first time for the same id then again check that same id is called so it doesn't call for second time instead it get that value from cache memory this is the smartness shown by the hibernate.

<br>
<b>let's understand load()</b>

Student studentLoad = (Student) session.get(Student.class, 102);

If you will write this statement then we can see that hibernate doesn't even fire the query of select means that until and unless print it

when we write this statement then only query will be executed 
<b>System.out.println(studentLoad.toString());</b>
<br>
Means that if we don't use the object then our hibernate won't fire the query. <b>This is called proxy object</b>
<br>
This is the major difference between the get() and load() method
<hr>
<b>Embedded annotation in hibernate</b>
<pre>
<code>
@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	@Embedded
	private Address address;
	
}
// Here address is a class

@Embeddable
public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	// getters and setters
}
</code>
saved in this Hibernate name folder inside src/main/java/com.hibernate and class name is EmDemo.java
Take a refernce and it will be easy to understand
</pre>

<hr>
<b>One to One Relation</b><br>
example:- 
<br>
one student can have one enrollment number.
<br>
one repo have one readme.md
<br>
This is called one to one relation
<br>
<pre>
<code>
@Entity
class Question {
	@Id
	private int qId;
	private String question;
	@OneToOne
	private Answer answer;
}
@Entity
class Answer {
	@Id
	private int aId;
	private String answer;
}
</code>
</pre>
<b>Note That this is unidirectional we are only going from Question to Answer but we can't go to Answer to Question</b>
<br>

<hr>