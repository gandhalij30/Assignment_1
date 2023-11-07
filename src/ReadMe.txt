--------------COHESION

1. It is the degree to which a class has one single focused responsibility .
2. It is strongly recommended that every class must have focused responsibility.
3. It is known as High Cohesion.

----------------COUPLING
1. It is degree to which one layer or class knows about other.
2. It is strongly recommended that classes must be loosely coupled.
3. In order to do this, one layer should talk to other only using Interface.


FOR CREATING FILE ARCHITECTURE

1.To help our application to talk to(Read,Insert, Update, Delete ) underline data store (in memory/database).
2.We need to create separate class which is solely responsible for this functionality.
3.In JAVA world this class is known as DAO (Data Access Object).
4.This is pattern followed by developers.
5.DAO class is typically responsible for implementing CRUD operations .

   

Layered Architecture design is the most common design pattern used in industry.
The idea behind this is Classes with similar functionalities are grouped 
or organized in a single unit.
Every unit is called a layer .
Thus every layer performs specific roles within application. 
Following are important and frequently used layers :
  1. DAO Layer
      DAO Layer is responsible for interaction with data store.
      (just talking with Database)
  2. Service Layer
      Responsible for carrying out business logic of the application.
  3. Controller Layer:
     Responsible for carrying out controller flow of application.
     
-------------------map()---------------------VS----------------------------flatMap()------------------

1.map() is used for transformation of data.        1.flatMap() is used for transformation and flattening.
2.map() is used to do one-to-one mapping.          2.flatMap() is used to do one-to-many mapping.
                                                   3.flatMap()converts nested data structure into one 
                                                     single flat stream. 

















      
