# java-spring-tv-shows
app allows logged in users to create tv shows and rate them.
* Full CRUD (Create, Read, Update, Delete) features.
### Relationships
* One-to-many relationship between Users and TV Shows
* One-to-many relationship between TV shows and Reviews
* One-to-many relationship between Users and Reviews

### Features
* Login and Registration with validations (e.g. prevent duplicate emails, etc.)
* Users can only review a tv show once
* Only users that create a tv show can edit/delete them. When a tv show is deleted, the corresponding reviews for that show are also deleted (cascade = CascadeType.REMOVE)
* Calculates avg rating for that tv show after each review and displays them
* Flash Messages