# TheFishPlaceProject
 We have to complete a project, and this is an effective way to work collaboratively.

One member of the group works at a fish store called The Fish Place.
They offer a deal where if you by some amount of some types of water you will receive credit equal to 20% of what you purchased when you have purchased a certain amount.

## Purchased "balance" required to withdraw credit:
|Type|Gallons|
|-|-|
|Filter Fresh|10|
|Reverse Osmosis|25|
|Instant Ocean, brackish, and Red Sea|50|


## Thing the code needs to do:

- When the user inputs a name or phone number the code will bring up the profile with all the water the customer has purchased.
- The code should conserve the remainder when credit is used (Example: if a customer has 68 gallons of saltwater purchased and wants 10 free gallons, it should still have 18 gallons left purchased).
- The customers profile should display their first and last name and phone number (phone number maybe optional and should be available to reprint into file at any time while viewing their profile.
- The customers profile should display all 5 types of water. 
- All info needs to be saved so we can refer to it in later instances of the program.
## Additional properties that would be nice:
- Have a way to show when the last time they bought water and what type of water they got.


## Customer File Format (all on one line per customer)
John Doe;                       name

000-000-0000;                   PhoneNumber

0.0;                            FilterFresh

0.0;                            ReverseOsmosis

0.0;                            InstantOcean

0.0;                            Brackish

0.0#                            RedSea

Sat Apr 09 21:50:21 CDT 2022;   Last purchase Date/Time    Date class toString()

0.0;                            FilterFresh

0.0;                            ReverseOsmosis

0.0;                            InstantOcean

0.0;                            Brackish

0.0                             RedSea

