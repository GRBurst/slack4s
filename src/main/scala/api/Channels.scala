/*
 * channel parameter stands for the id of a channel
 * name stands for the name of a channel
 * TODO: LimitedChannel?  
 *
 * Note: Naming
 * Channel names can only contain lowercase letters, numbers, hyphens, and underscores, and must be 21 characters or less. We will validate the submitted channel name and modify it to meet the above criteria. When calling this method, we recommend storing the channel's name value that is returned in the response.
 *
 * Channel object: https://api.slack.com/types/channel
 */

package slack4s.api

class Channels[C, M[_]]() = {
  type ChannelId = String
  type UserId = String

  /**
   * Archives a channel.
   * https://api.slack.com/methods/channels.archive
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @return A boolean SlackResponse whether the action was successful.
   */
  def archieve(
    token: OAuthToken,
    channel: ChannelId,
    ): M[SlackResponse[Boolean]] = ???


  /**
   * Creates a new channel.
   * https://api.slack.com/methods/channels.create
   *
   * @param token Authentication token to identify the user.
   * @param name Name of the channel to create.
   * @param validate Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   * @return A SlackResponse with the created channel.
   */
  def create(
    token: OAuthToken,
    name: String,
    validate: Option[Boolean] = None,
    ): M[SlackResponse[Channel]] = ???


  /**
   * Fetches history of messages and events from a channel.
   * https://api.slack.com/methods/channels.history
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param count Number of messages to return, between 1 and 1000.
   * @param inclusive Include messages with latest or oldest timestamp in results.
   * @param latest End of time range of messages to include in results.
   * @param oldest Start of time range of messages to include in results.
   * @param unreads Whethet to include `unread_count_display` in the output.
   * @return A SlackResponse containing the channel's history.
   */
  def history(
    token: OAuthToken,
    channel: ChannelId,
    count: Option[Int] = None
    inclusive: Option[Int] = None,
    latest: Option[String] = None,
    oldest: Option[String] = None,
    unreads: Option[Boolean] = None,
    ): M[SlackResponse[HistoryChunk]] = ???

  /**
   * Gets information about a channel.
   * https://api.slack.com/methods/channels.info
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param includeLocale Whether to receive the locale for this channel.
   * @return A SlackResponse containing a channel.
   */
  def info(
    token: OAuthToken,
    channel: ChannelId,
    includeLocale: Option[Boolean] = None,
    ): M[SlackResponse[Channel]] = ???

  /**
   * Invites a user to a channel.
   * https://api.slack.com/methods/channels.invite
   *
   * Note: The calling user must be a member of the channel.
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param user Id of the user getting invited to channel.
   * @return A SlackResponse containing a channel.
   */
  def invite(
    token: OAuthToken,
    channel: ChannelId,
    user: UserId,
  ): M[SlackResponse[Channel]] = ???

  /**
   * Joins a channel, creating it if needed.
   * https://api.slack.com/methods/channels.join
   *
   * @param token Authentication token to identify the user.
   * @param name Name of the channel to join.
   * @param validate Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   * @return A SlackResponse containing a channel.
   */
  def join(
    token: OAuthToken,
    name: String,
    validate: Option[Boolean] = None,
  ): M[SlackResponse[Channel]] = ???

  /**
   * Removes a user from a channel.
   * https://api.slack.com/methods/channels.kick
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param user Id of the user getting removed from the channel.
   * @return A boolean SlackResponse whether the action was successful.
   */
  def kick(
    token: OAuthToken,
    channel: ChannelId,
    user: UserId,
  ): M[SlackResponse[Boolean]] = ???

  /**
   * Leave a channel.
   * https://api.slack.com/methods/channels.leave
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @return A boolean SlackResponse whether the action was successful.
   */
  def leave(
    token: OAuthToken,
    channel: ChannelId,
  ): M[SlackResponse[Boolean]] = ???

  /**
   * Lists all channels in a Slack team.
   * https://api.slack.com/methods/channels.list
   *
   * @param token Authentication token to identify the user.
   * @param cursor Pagination control parameter.
   * @param excludeArchived Exclude archived channels from the list
   * @param excludeMembers Exclude the `members` collection from each `channel`
   * @param limit The maximum number of items to return.
   * @return A SlackResponse containing a list of limited channel objects.
   */
  def list(
    token: OAuthToken,
    cursor: Option[String] = None,
    excludeArchived: Option[Boolean] = None,
    excludeMembers: Option[Boolean] = None,
    limit: Option[Int] = None,
  ): M[SlackResponse[List[LimitedChannel]]] = ???


  /**
   * Sets the read cursor in a channel.
   * https://api.slack.com/methods/channels.mark
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param ts: UnixTimestamp of the most recently seen message.
   * @return A boolean SlackResponse whether the action was successful.
   */
  def mark(
    token: OAuthToken,
    channel: ChannelId,
    ts: UnixTimestamp,
  ): M[SlackResponse[Boolean]] = ???

  /**
   * Renames a team channel.
   * https://api.slack.com/methods/channels.rename
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param name New name of the channel.
   * @param validate Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria.
   * @return A SlackResponse containing a channel.
   */
  def rename(
    token: OAuthToken,
    channel: ChannelId,
    name: String,
    validate: Option[Boolean] = None,
  ): M[SlackResponse[Channel]] = ???

  /**
   * Retrieve an entire thread (mesages and all the reply messages) posted to a channel.
   * https://api.slack.com/methods/channels.replies
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param threadTs: UnixTimestamp that uniquely identifies a thread's parent message
   * @return A SlackResponse containing the replied messages.
   */
  def replies(
    token: OAuthToken,
    channel: ChannelId,
    threadTs: UnixTimestamp,
  ): M[SlackResponse[List[RepliesChunk]]] = ???

  /**
   * Sets the purpose for a channel.
   * https://api.slack.com/methods/channels.setPurpose
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param purpose: The new purpose.
   * @return A SlackResponse containing the set purpose.
   */
  def setPurpose(
    token: OAuthToken,
    channel: ChannelId,
    purpose: String,
  ): M[SlackResponse[String]] = ???

  /**
   * Sets the topic for a channel.
   * https://api.slack.com/methods/channels.setTopic
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param topic: The new topic.
   * @return A SlackResponse containing the set topic.
   */
  def setTopic(
    token: OAuthToken,
    channel: ChannelId,
    topic: String,
  ): M[SlackResponse[String]] = ???

  /**
   * Unarchives a channel.
   * https://api.slack.com/methods/channels.unarchive
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @return A boolean SlackResponse whether the action was successful.
   */
  def unarchive(
    token: OAuthToken,
    channel: ChannelId,
  ): M[SlackResponse[Boolean]] = ???

}
