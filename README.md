########## dancing-queen-api ###########

This will provide the services required to run DancingQueenApp.

This is a playground practice for a dockerized Application.

Notes to build and run docker containters:

1. Posgresql and dancing-queen-api must run under the same network. Must expose ports as follows:
    postgresql 5432:5432
    dancing-queen-api 8080:8080
2. Remember to deploy first postgres container and create a DB named "dqdb" inside.
3. Use this to deploy dancing-queen-api as container:
    docker run -e SPRING_PROFILES_ACTIVE=prod -p 8080:8080 --name dq_api_nw --network my-network -d dq_api


    
