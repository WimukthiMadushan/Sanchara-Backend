# Sanchara-Backend

Follow the steps below to run the backend using Docker:

### 📁 Step 1: Navigate to the Project Root

Ensure you're in the root folder of the project. The root folder is named: "demo"  



### 🐳 Step 2: Launch Docker Desktop
Make sure Docker Desktop is running on your machine before proceeding.

If it's not already running, open Docker Desktop from your applications menu.

Wait until Docker is fully initialized.  



### ⚙️ Step 3: Build and Start the Application
Run the following command to build the Docker image and start the backend services:

`docker-compose up --build`

This will:

- Build all services as defined in the docker-compose.yml
- Start the containers and run the backend application

ℹ️ Tip: The --build flag ensures that any changes in the Dockerfile or dependencies are reflected by rebuilding the image.
