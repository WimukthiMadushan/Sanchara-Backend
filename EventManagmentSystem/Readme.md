# Event Management Service

This service is responsible for managing events. It provides the following functionalities:

- Create an event
- Update an event
- Delete an event
- Get an event
- Get all events

## API Documentation
POST /event/create
```	{
  "_id": "EVT001",
  ""host_Id":"ID"
  "eventName": "Music Fest",
  "owner":"Charana 02",
  "country": "Sri Lanka",
  "city": "Colombo",
  "venue": "Galle Face Green",
  "latitude": "6.927079",
  "longitude": "79.861244",
  "date": "2025-06-15T18:00:00Z",
  "eventType": "Entertainment", 
  "coverImage": "URL",
  "coverImageThumbnail":"URL",
  "images":[],
  "wishlist":20,
  "createdAt": "2025-03-18T10:00:00Z",
  "updatedAt": "2025-03-18T10:00:00Z"
}
```
PUT /event/update/:id
```	{
  "_id": "EVT001",
  ""host_Id":"ID"
  "eventName": "Music Fest",
  "owner":"Charana 02",
  "country": "Sri Lanka",
  "city": "Colombo",
  "venue": "Galle Face Green",
  "latitude": "6.927079",
  "longitude": "79.861244",
  "date": "2025-06-15T18:00:00Z",
  "eventType": "Entertainment", 
  "coverImage": "URL",
  "coverImageThumbnail":"URL",
  "images":[],
  "wishlist":20,
  "createdAt": "2025-03-18T10:00:00Z",
  "updatedAt": "2025-03-18T10:00:00Z"
}
```
GET /event/get/:id
DELETE /event/delete/:id
GET /event/trending/:limit/:id

GET /event/list/:id --> Get all events of a particular Host

## Kafka Topics
- **EventCreated** - This topic is used to notify all the users who are following the host of the event when a new event is created.


