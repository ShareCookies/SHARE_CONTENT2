
@ApiModel("督查任务反馈表")
public class UrgerTaskFeedback implements Serializable {
	...
    /**
     * @description 当前任务是否已经反馈。
     * <p>
     *     判断是否已经任务是否算反馈，都用这个方法。
     *     避免反馈状态变更，但有些用反馈状态来判断是否反馈的地方没进行及时更改，导致数据异常。
     * </p>
     * @author hecaigui
     * @date 2021-3-16
     * @param
     * @return
     */
    public boolean isHasFeedback(){
        if ("1".equals(feedbackStatus) || "5".equals(feedbackStatus) || "6".equals(feedbackStatus)){
            return true;
        }
        return false;
    }
}
