Set up the backend for an online store to buy items.
Users can register and log in to add items to their cart. Then they can place orders.
Registered users are stored in the Users table.
Items that users can buy are stored in the Items table.
User's carts are stored in the Cart table.
Users orders are stored in the Orders table.

Features to be Implemented
-Register - register new users
-Login/Logout - login and logout users
-Get Users - get all users
-Get Items - gets all items that are available in store // complete
-Add Item to Cart - adds selected item to the cart
-Spring http security with default user:jay password:tiger
-http://localhost:8099
- POST: http://localhost:8099/users
- GET: http://localhost:8099/{userId}
- PUT: http://localhost:8099
- DELETE: http://localhost:8099/{userId}

-ADMIN login for application: user: jayden password: tiger
// disabled by comment for ease of testing on UserController
