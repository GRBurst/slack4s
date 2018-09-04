package slack4s.api

import slack4s.slack4s.SlackResponse
import slack4s.util.TypeDsl._

sealed trait ParseOption
case object ParseFull extends ParseOption
case object ParseNone extends ParseOption

class Chat[C, M[_]]() {
  type ChannelId = String

  // Tuple that uniquely identifies a message
  case class MessageId(channel: String, ts: UnixTimestamp)

  /**
   * Deletes a message.
   * https://api.slack.com/methods/chat.delete
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param ts UnixTimestamp to identify the message.
   * @param asUser Apply the action as the authed user.
   * @return A SlackResponse containing information to identify the message.
   */
  def delete(
    token: OAuthToken,
    channel: ChannelId,
    ts: UnixTimestamp,
    asUser: Option[Boolean] = None,
    ): M[SlackResponse[MessageId]] = ???

  /**
   * Retrieve a permalink URL for a specific extant message.
   * https://api.slack.com/methods/chat.getPermalink
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param messageTs UnixTimestamp of the most recently seen message.
   * @return A SlackResponse containing the permalink URL.
   */
  def getPermalink(
    token: OAuthToken,
    channel: ChannelId,
    messageTs: UnixTimestamp,
    ): M[SlackResponse[Uri]] = ???

  /**
   * Share a me message into a channel.
   * https://api.slack.com/methods/chat.meMessage
   *
   * @param token Authentication token to identify the user.
   * @param channel Id of the channel.
   * @param text Text of the message to send.
   * @return A SlackResponse containing information to identify the message.
   */
  def meMessage(
    token: OAuthToken,
    channel: ChannelId,
    text: String,
    ): M[SlackResponse[MessageId]] = ???

  /**
   * Sends an ephemeral message to a user in a channel.
   * https://api.slack.com/methods/chat.postEphemeral
   *
   * @param token Authentication token to identify the user.
   * @param channel ChannelId of the channel.
   * @param text Text of the message to send.
   * @param user Id of the user who will receive the ephemeral message.
   * @param asUser Apply the action as the authed user.
   * @param attachments A JSON-based array of structured attachments, presented as a URL-encoded string.
   * @param linkNames Find and link channel names and usernames.
   * @param parse Change how messages are treated.
   * @return A SlackResponse containing the message timestamp.
   */
  def postEphemeral(
    token: OAuthToken,
    channel: ChannelId,
    text: String,
    user: UserId,
    asUser: Option[Boolean] = None,
    attachments: Option[Seq[Attachment]] = None,
    linkNames: Option[Boolean] = None,
    parse: Option[ParseOption] = None,
    ): M[SlackResponse[UnixTimestamp]] = ???

  /**
   * Sends a message to a channel.
   * https://api.slack.com/methods/chat.postMessage
   *
   * @param token Authentication token to identify the user.
   * @param channel ChannelId of the channel.
   * @param text Text of the message to send.
   * @param asUser Apply the action as the authed user.
   * @param attachments A JSON-based array of structured attachments, presented as a URL-encoded string.
   * @param iconEmoji Emoji to use as the icon for this message.
   * @param iconUrl URL to an image to use as the icon for this message.
   * @param linkNames Find and link channel names and usernames.
   * @param mrkdwn Disable Slack markup parsing by setting to false.
   * @param parse Change how messages are treated.
   * @param replyBroadcast Used in conjunction with thread_ts and indicates whether reply should be made visible to everyone in the channel or conversation.
   * @param threadTs Provide another message's ts value to make this message a reply.
   * @param unfurlLinks Pass true to enable unfurling of primarily text-based content.
   * @param unfurlMedia Pass false to disable unfurling of media content.
   * @param username Set your bot's user name.
   * @return A SlackResponse containing the created message.
   */
  def postMessage(
    token: OAuthToken,
    channel: ChannelId,
    text: String,
    asUser: Option[Boolean] = None,
    attachments: Option[Seq[Attachment]] = None,
    iconEmoji: Option[String] = None,
    iconUrl: Option[Uri] = None,
    linkNames: Option[Boolean] = None,
    mrkdwn: Option[Boolean] = None,
    parse: Option[ParseOption] = None,
    replyBroadcast: Option[Boolean]= None,
    threadTs: Option[UnixTimestamp] = None,
    unfurlLinks: Option[Boolean] = None,
    unfurlMedia: Option[Boolean] = None,
    username: Option[String] = None,
  ): M[SlackResponse[Message]] = ???

  /**
   * Provide custom unfurl behavior for user-posted URLs
   * https://api.slack.com/methods/chat.unfurl
   *
   * @param token Authentication token to identify the user.
   * @param channel ChannelId of the channel.
   * @param ts UnixTimestamp to identify the message.
   * @param unfurls URL-encoded JSON map with keys set to URLs featured in the the message, pointing to their unfurl message attachments.
   * @param userAuthMessage Provide a simply-formatted string to send as an ephemeral message to the user as invitation to authenticate further and enable full unfurling behavior.
   * @param userAuthRequired Set to true to indicate the user must install your Slack app to trigger unfurls for this domain.
   * @param userAuthUrl end users to this custom URL where they will complete authentication in your app to fully trigger unfurling. Value should be properly URL-encoded.
   * @return A boolean SlackResponse whether the action was successful.
   */
  def postEphemeral(
    token: OAuthToken,
    channel: ChannelId,
    ts: UnixTimestamp,
    unfurls: String, // DataType?
    userAuthMessage: Option[String] = None,
    userAuthRequired: Option[Boolean] = None,
    userAuthUrl: Option[Uri] = None,
    ): M[SlackResponse[UnixTimestamp]] = ???

  /**
   * Updates a message.
   * https://api.slack.com/methods/chat.update
   *
   * @param token Authentication token to identify the user.
   * @param channel ChannelId of the channel.
   * @param text Text of the message to update.
   * @param ts UnixTimestamp to identify the message.
   * @param asUser Apply the action as the authed user.
   * @param attachments A JSON-based array of structured attachments, presented as a URL-encoded string.
   * @param linkNames Find and link channel names and usernames.
   * @param parse Change how messages are treated.
   * @return A SlackResponse containing the updated message.
   */
  def update(
    token: OAuthToken,
    channel: ChannelId,
    text: String,
    ts: UnixTimestamp,
    asUser: Option[Boolean] = None,
    attachments: Option[Seq[Attachment]] = None,
    linkNames: Option[Boolean] = None,
    parse: Option[ParseOption] = None,
    ): M[SlackResponse[Message]] = ???
}
