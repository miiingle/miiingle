# Mongo GeoLocation 
Testing out the waters in geo-location queries on Mongo DB

```javascript
db.userloc.createIndex( { "location" : "2dsphere" } )

db.userloc.insert({
	userId: "test",
	location: { type: "Point", coordinates: [ -73.97, 40.77 ] }
})
```

## Query
```javascript
db.userloc.find({
	location: {
		$near: {
			$geometry: { type: "Point",  coordinates: [ -73.9667, 40.78 ] },
            		$minDistance: 1000,
            		$maxDistance: 5000
		}
	}
})
```

## Query Combination
```javascript
db.userloc.insert({
	userId: "test4",
	location: { type: "Point", coordinates: [ -75.97, 40.77 ] },
	friends: ["test1", "test2", "test4"]
})

db.userloc.insert({
	userId: "test1",
	location: { type: "Point", coordinates: [ -75.97, 40.77 ] },
	friends: ["test2"]
})

db.userloc.insert({
	userId: "test5",
	location: { type: "Point", coordinates: [ -75.97, 40.77 ] },
	friends: ["test4"]
})

db.userloc.find({
	location: {
		$near: {
			$geometry: { type: "Point",  coordinates: [ -75.9667, 40.78 ] },
	        $minDistance: 1000,
	        $maxDistance: 5000
		}
	}, 
	"friends": "test4"
})
```

###### Resources:
- [Documentation: Mongo GeoQueries](https://docs.mongodb.com/manual/geospatial-queries/)
- [Article About GeoLocation Storage](https://ralphbarbagallo.com/2011/04/02/an-overview-of-geospatial-databases/)
