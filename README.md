# MyTourGuide

Flow explanation:
	***********
	Admin User:
	***********
	George being the admin has the accesses the following url to get the details for a particular date:
	http://localhost:8081/admin/dd-mm-yyyy    ----> Request Type = GET, AUTHENTICATION_TYPE = BASIC_AUTH
	Ex: http://localhost:8081/admin/26-12-2020 
	Sample Output:
	[
    {
        "id": 3,
        "totalSum": 89.70,
        "hikerName": "Mary",
        "hikerAge": 22,
        "age": 22,
        "packageName": "Shire",
        "bookingDate": "26-12-2020",
        "otherHikerDetails": [
            "Doe:19",
            "John:40"
        ]
    }
]
	The link is only accessible using the above credentials
	
	Hiker:
	A hiker needs to signup using the following URL and use the credentials set using the URL:
	localhost:8081/user/signUp       ----> Request Type = POST	, no authentication
	Sample JSON body:
	{
    "username":"testuser",
    "password":"test1"
	}
	
	*****************
	CREATING NEW HIKE:
	*****************
	Once the user registers, he can use the credentials entered in the previous step to register for a Hike:
	localhost:8081/hiker    -> Request type = POST , CREDENTIALS: BASIC_AUTH
	
	Sample JSON Body:
	{
    "age":22,
    "packageName":"Shire",
    "bookingDate":"26-12-2020",
    "otherHikerDetails":["Doe:19","John:40"]
	}
	
	Sample Output:
	{
    "id": 4,
    "totalSum": 89.70,
    "hikerName": "sample",
    "hikerAge": 20,
    "age": 20,
    "packageName": "Shire",
    "bookingDate": "26-12-2020",
    "otherHikerDetails": [
        "Doe:19",
        "John:40"
    ]
	}
	
	-> Name of the person booking package is taken from UserName
	-> If Age of person booking the package is incorrect -> Age limit of hiker not within limit is shown in JSONResponse
	-> if PackageName does not exist -> Package does not exist <Package name> is thrown
	-> Booking date -> Booking Date can only be in future
	-> OtherHikerDetails -> OtherHikerDetails is an array of elements with Name and Age seperated by :, if the age is not in limit exception thrown is "Age limit of one of the hikers is not within limit"
	
	
	*********************
	VIEWING HIKE DETAILS:
	*********************
	Once the hike has been created the user may view the Hike details. A USER MAY ONLY VIEW HIKE DETAILS WHICH WERE CREATED WITH THE SAME CREDENTIALS. For example, if user creates a hike with authentication username as "test", he may only view the records created by him. In case he tries to view a record created by user "test1" the following error is displayed:
	
	message": "Record not created by this user"
	
	If record is not available the following message is displayed:
	"Could not find entity with id: <ID>"
	
	URL: localhost:8081/hiker/id    -> Request type = GET , CREDENTIALS: BASIC_AUTH
	Sample:localhost:8081/hiker/1
	
	**********************
	UPDATING HIKE DETAILS:
	**********************
	Once the hike has been created the user may update the Hike details. A USER MAY ONLY UPDATE HIKE DETAILS WHICH WERE CREATED WITH THE SAME CREDENTIALS. For example, if user creates a hike with authentication username as "test", he may only update the records created by him. In case he tries to update a record created by user "test1" the following error is displayed:
	
	message": "Record not created by this user"
	URL: localhost:8081/hiker/id     -> Request type = PUT , CREDENTIALS: BASIC_AUTH
	Sample: localhost:8081/hiker/1 
	
	Sample Json Body:
	{
    "age":20,
    "packageName":"Gondor",
    "bookingDate":"25-12-2020",
    "otherHikerDetails":["Doe:19","Mary:40"]

	}
	
	Sample JSONResponse:
	Status 200OK
	
	**********************
	DELETING HIKE DETAILS:
	**********************
	Once the hike has been created the user may delete the Hike details. A USER MAY ONLY DELETE HIKE DETAILS WHICH WERE CREATED WITH THE SAME CREDENTIALS. For example, if user creates a hike with authentication username as "test", he may only delete the records created by him. In case he tries to delete a record created by user "test1" the following error is displayed:
	
	message": "Record not created by this user"
	URL: localhost:8081/hiker/id     -> Request type = DELETE , CREDENTIALS: BASIC_AUTH
	Sample: localhost:8081/hiker/1 
	
	
	Sample JSONResponse:
	Status 200OK
	
	***********
	USER SIGNUP
	***********
	
	Credentials(Case sensitive):
	userName:admin
	Password:pwd

	User Creation: 
	localhost:8081/user/signUp     -> The following url may be used to create new users
	A new user created has role of "Hiker".
	
	Following users have already been created :
	Hiker Role -> UserName: sample password:pwd
	Admin Role(george) -> UserName:admin password:pwd
	
	signUp does not allow us to create admin user as George is the only user with Admin Access
	
	
	Use the following URL to register a User:
	localhost:8081/user/signUp

Sample JSON body:
{
    "username":"testUser",
    "password":"test1"

}
