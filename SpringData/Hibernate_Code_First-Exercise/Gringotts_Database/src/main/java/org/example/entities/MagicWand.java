package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "magic_wand")
public class MagicWand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "magic_wand_creator", length = 1000, columnDefinition = "Text")
    private String creator;

    @Column(name = "magic_wand_size")
    private Integer size;

    public MagicWand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
