This application shows various Spring Jackson integration features.

Run the Application.main() with a Java 8 runtime to start the embedded Tomcat on port 8080.

Some URL to try:
 * Get one message (JSON): http://localhost:8282/1.json or curl -X GET -H "Cache-Control: no-cache" http://localhost:8282/1.json
 * Get one message (JSONP) : http://localhost:8282/1.json?jsonp=parseResponse or curl -X GET -H "Cache-Control: no-cache" http://localhost:8282/1.json?jsonp=parseResponse
 * Get all messages with Json View (JSON): http://localhost:8282/.json or curl -X GET -H "Cache-Control: no-cache" http://localhost:8282/.json
 * Get one Message (XML): http://localhost:8282/1.xml or curl -X GET -H "Cache-Control: no-cache" http://localhost:8282/1.xml
 * Get all messages with Json View (XML): http://localhost:8282/.xml or curl -X GET -H "Cache-Control: no-cache"  http://localhost:8282/.xml

