FROM ubuntu:latest

RUN apt-get update \
    && apt-get install -y python3

FROM python:3.10
ADD main.py .

CMD ["python3", "./main.py"]