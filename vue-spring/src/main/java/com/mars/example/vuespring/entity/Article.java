package com.mars.example.vuespring.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonPropertyOrder(value = {"content", "title"})
public class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
    private Integer id;
    private String title;
    private String content;
    private String last_update;

//    @JsonProperty("auther")
    private Integer author_id;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-4")
    private String created_time;

//    @JsonInclude(JsonInclude.Include.NON_NULL)

}
