# init a base image (Alpine is small Linux distro)
FROM python:3.9-alpine
# define the present working directory
WORKDIR /my-flask-app
# copy the contents into the working dir
ADD . /my-flask-app
# run pip to install the dependencies of the flask app
RUN pip3 install -r requirements.txt
# define the command to start the container
CMD ["python3","app.py"]