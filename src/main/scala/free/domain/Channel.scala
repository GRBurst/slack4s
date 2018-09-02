package slack4s.free.domain

/**
 * This is the channel domain which includes channel models and return types
 */

// TODO: tag types
type ChannelId = String
type UserId = String

type SlackTimestamp = String
type UnixTimestamp = Long

case class Channel (
  id: String,
  name: String,
  name_normalized: String,
  created: UnixTimestamp,
  creator: Option[String],
  is_archived: Option[Boolean],
  is_channel: Option[Boolean],
  is_general: Option[Boolean],
  is_group: Option[Boolean],
  is_member: Option[Boolean],
  is_mpim: Option[Boolean],
  is_private: Option[Boolean],
  last_read: Option[SlackTimestamp],
  latest: Option[Message],
  members: Option[Seq[UserId]],
  num_members: Option[Int],
  previous_names: Option[Seq[String]],
  purpose: Option[ChannelProperty],
  topic: Option[ChannelProperty],
  unread_count: Option[Int],
  unread_count_display: Option[Int]
)

case class ChannelProperty (
  value: String,
  creator: String,
  last_set: Long,
)

case class ChannelHistory (
  latest: Option[String],
  messages: Seq[HistoryMessage],
  has_more: Boolean,
)

sealed trait HistoryMessage {
  def ts: String
  def text: String
}

case class UserMessage(
  ts: String,
  text: String,
  user: String,
  ) extends HistoryMessage

case class BotMessage(
  ts: String,
  text: String,
  bot_id: String,
  username: Option[String],
  ) extends HistoryMessage
