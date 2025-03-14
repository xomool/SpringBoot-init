package com.tyto.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求(非批量)
 */
@Data
public class DeleteRequest implements Serializable {

    private final static long serialVersionUID = 1L;

    private Long id;
}
