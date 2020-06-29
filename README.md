# fizzbuzz
FizzBuzz API

API which returns the FizzBuzz sequence.

Build:
docker image build -t fizzbuzz .

Run:
docker run -p 8080:8080 fizzbuzz

Sample request:
curl http://localhost:8080/api/v1/fizzbuzz/10

Response: 
{"sequence":["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz"]}
