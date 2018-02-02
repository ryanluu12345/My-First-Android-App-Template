# My-First-Android-App-Template
Template used in Android development workshop during HackUCI 2018

# My-First-Android-App
Introductory mobile application that was used for instructional purposes during HackUCI 2018. This tutorial is split up into 4 parts:
1) Introductory information about Android
2) Introducing the code and basics of Java
3) Developing your first app
4) Deploying to your mobile device or an emulator

# Introduction to Android Vocabulary
- build.Gradle: The tool that builds your application. A script that runs that automates the process of building an application. Built on top of Apache Maven and Apache Ant

- Manifest: Defines the entire application by its characteristics and the components that constitute it. Also where you place permissions for accessing different functionality of a phone. 

- Android Activity: The activity initiates an Android program and is typically characterized by the onCreate() method, which should be nested in the Activity object

- Other Important Activity Methods:
onStart(): Called whenever the activity becomes visible for the user
onResume(): Called whenever the user interacts with the application
onStop(): Called when the activity is no longer visible
For further reading: https://www.tutorialspoint.com/android/android_acitivities.htm

- AppCompatActivity: A base class that provides newer features on older versions of Android. Also defaults to older features if the newer features are not available on older versions. Essentially allows for backward compatibility. Important since it allows for simpler development and wider support

- setContentView(): A method that sets the layout of the page to the XML page specified

- Bundle: Used to pass data between activities. Also used to retain data about a page when the state changes (i.e. orientation of the device, browser changes, etc.)

- Android Layouts: Layouts are defined in XML files. They are a bit cumbersome at first but you will see the usefulness of the clear organization when you undertake larger projects. Works similarly to HTML/CSS

- Types of Layouts:
Constraint Layout: Allows for flexible layouts that are defined by constraints between elements in a layout. Constraints are the criteria for determining the position of UI elements. Tutorial link: https://codelabs.developers.google.com/codelabs/constraint-layout/#0

Linear Layout: View group that aligns all children elements in a single direction, either vertically or horizontally

Relative Layout: View group that aligns children in relative positions

List View: View group that displays a list of scrollable items

More can be found here: https://www.tutorialspoint.com/android/android_user_interface_layouts.htm

- Within View UI Elements:
Take a look at the elements on the upcoming link. I will not go into detail since most of the items are self explanatory. I will be explaining in detail during the workshop.

# The Code

Creation of an activity:

```
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.foodItems=new ArrayList();
        this.itemTv=(TextView) findViewById(R.id.foodItem);
    }
```
The above method creates the view and builds the UI. It also instantiates data stores and links a variable to the foodItem text view. The setContentView() function sets a layout for the activity.


Button bound methods:
```
    public void onAddItem(View v){

        //Adds grocery items to a previously initialized ArrayList
        String addedItem=this.itemTv.getText().toString();
        this.foodItems.add(addedItem);

    }
 ```
Methods of this type (public, void, and view as an argument) are methods that are bound to buttons in the XML layouts. These methods perform actions whenever an event is triggered by the button. In this example, this button method adds an item to an ArrayList whenever a button is clicked.

Intents to other activities:
 ```
 Intent viewListIntent=new Intent(this,ViewListActivity.class);
 viewListIntent.putStringArrayListExtra("groceryList",this.foodItems);
 startActivity(viewListIntent);
 
 ```
An intent is responsible for taking a user from one activity or application to another. Here is a breakdown of the code:
- In the first line, the Intent object is instantiated and the current activity is passed as the first argument. The target activity is passed as the second argument.
- In the second line, a string array list is attached to the intent, meaning that it will be sent along with the intent. You can also attach Hashmaps, Lists, Arrays, and other objects (!!!CAUTION: If passing serializable types like Hashmaps or ArrayLists, make sure that your main class implements Serializable)
- In the third line, the intent to the target activity is initiated and executed

Intents to SMS/messaging:
```
Intent messageIntent=new Intent(Intent.ACTION_VIEW);
messageIntent.putExtra("sms_body",message);
messageIntent.setType("vnd.android-dir/mms-sms");
startActivity(messageIntent);
```
This particular intent is very similar to the previous one. However, the functionality is different. The purpose of this intent is to leverage the messaging functionality of a phone. It sets the type of intent as short messaging and attaches a message as the short message body. The intent is initiated in the same manner. 

Array adapters and list views:
```
//Creates the array adapter and populates with the ArrayList
groceryListAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.groceryList);

//Obtain the list view
groceryListLv=(ListView) findViewById(R.id.groceryListView);

//Connect the list view to the array adapter
groceryListLv.setAdapter(groceryListAdapter);

```
Array adapters are used to adapt ArrayLists and Arrays into items that can be consumed by and integrated into a view. Here is a breakdown of the code:
- The first line of code creates the array adapter object. The arguments are (the reference to the object, the type of layout for the adapter, the list or array you want to adapt to)
- The second line of code obtains the reference to the ListView and accesses the object's functionality
- The third line of code links the groceryListLv ListView to the adapter that was previously defined and fitted on our data

# Upcoming Challenges
Congratulations! You have just completed your first Android application, during which you learned how to construct layouts and the UI, write helper functions to process data in the backend, inject data on the frontend, make intents to other activities and your phone, and deploy to a device or emulator. So what's next?

Challenges:
- Touch up the UI and make it look more presentable
- Use an API or web scrape to get data for the different foods in the grocery list
- Experiment with data persistence by using a popular NoSQL (Firebase or MongoDB) or SQL database (Microsoft SQL, MySQL)
- Allow for a collaborative grocery list experience by making lists available for different users at a given time
- If you are really ambitious, link different foods on the list and place them on a map so that people can visually see where they can purchase such items (Google Maps API)
- Apply what you learned in this workshop to another problem that you want to solve or application you want to create
