package base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DogObject {
    String message;
    String status;
    String code;

    public DogObject(@JsonProperty("message") String message,
                     @JsonProperty("status") String status,
                     @JsonProperty("code") String code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

    @Override
    public String toString() {
        return "DogObject{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
