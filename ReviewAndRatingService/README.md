# Review And Rating Service

## Description
This service is responsible for managing reviews and ratings for events. It provides the following functionalities:
- Add a review and rating for an event
- Get all reviews and ratings for an event
- Get all reviews and ratings for a user(Guest)

## Database Structure
The database structure for this service is as follows:
```json"
	{
  "Review iD": "001",
  "Event ID":"EVT001",
  "reviews": [
    {
      "userId": "USR123",
      "username": "JohnDoe",
      "comment": "Amazing event! Loved the atmosphere.",
      "rating": 5,
      "reviewDate": "2025-03-10T15:30:00Z"
    },
    {
      "userId": "USR456",
      "username": "JaneDoe",
      "comment": "Good event but the venue was overcrowded.",
      "rating": 4,
      "reviewDate": "2025-03-11T12:00:00Z"
    }
  ],

  "createdAt": "2025-03-18T10:00:00Z",
  "updatedAt": "2025-03-18T10:00:00Z"
}
```

## API Endpoints
The service provides the following API endpoints:
- POST /review/: Add a review and rating for an event
```json
{
  "userId": "USR123",
  "eventId": "EVT001",
  "FirstName": "JohnDoe",
  "comment": "Amazing event! Loved the atmosphere."
}
```
- GET /review/:{eventId} Get all reviews and ratings for an event
- GET /review/user/:{userId} Get all reviews and ratings for a user(Guest)
