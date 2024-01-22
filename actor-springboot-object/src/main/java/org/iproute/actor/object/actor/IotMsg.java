package org.iproute.actor.object.actor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * IotMsg
 *
 * @author zhuzhenjie
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class IotMsg {
    private int id;
    private String name;
}
