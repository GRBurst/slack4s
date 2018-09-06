package slack4s.free.algebra

import slack4s.util.TypeDsl._
import slack4s.free.domain._
import slack4s.slack4s.{OAuthToken, SlackResponse}
import cats.InjectK
import cats.free.Free


/**
 * Channels ADT
 */
sealed trait ChannelOp[A]

final case class ArchiveChannel(
  token: OAuthToken,
  channel: ChannelId,
  ) extends ChannelOp[SlackResponse[Boolean]]

final case class CreateChannel(
  token: OAuthToken,
  name: String,
  validate: Option[Boolean] = None,
  ) extends ChannelOp[SlackResponse[Channel]]

final case class GetChannelHistory(
  token: OAuthToken,
  channel: ChannelId,
  count: Option[Int] = None,
  inclusive: Option[Int] = None,
  latest: Option[String] = None,
  oldest: Option[String] = None,
  unreads: Option[Boolean] = None,
  ) extends ChannelOp[SlackResponse[Seq[ChannelHistory]]]

final case class GetChannelInfo(
  token: OAuthToken,
  channel: ChannelId,
  includeLocale: Option[Boolean] = None,
  ) extends ChannelOp[SlackResponse[Channel]]

final case class ChannelInvite(
  token: OAuthToken,
  channel: ChannelId,
  user: UserId,
  ) extends ChannelOp[SlackResponse[Channel]]

final case class ChannelJoin(
  token: OAuthToken,
  name: String,
  validate: Option[Boolean] = None,
  ) extends ChannelOp[SlackResponse[Channel]]

final case class ChannelKick(
  token: OAuthToken,
  channel: ChannelId,
  user: UserId,
  ) extends ChannelOp[SlackResponse[Boolean]]

final case class LeaveChannel(
  token: OAuthToken,
  channel: ChannelId,
  ) extends ChannelOp[SlackResponse[Boolean]]

final case class ListChannels(
  token: OAuthToken,
  cursor: Option[String] = None,
  excludeArchived: Option[Boolean] = None,
  excludeMembers: Option[Boolean] = None,
  limit: Option[Int] = None,
  ) extends ChannelOp[SlackResponse[Seq[LimitedChannel]]]

final case class MarkChannel(
  token: OAuthToken,
  channel: ChannelId,
  ts: UnixTimestamp,
  ) extends ChannelOp[SlackResponse[Boolean]]

final case class RenameChannel(
  token: OAuthToken,
  channel: ChannelId,
  name: String,
  validate: Option[Boolean] = None,
  ) extends ChannelOp[SlackResponse[Channel]]

final case class GetChannelReplies(
  token: OAuthToken,
  channel: ChannelId,
  threadTs: UnixTimestamp,
  ) extends ChannelOp[SlackResponse[Seq[RepliesChunk]]]

final case class SetChannelPurpose(
  token: OAuthToken,
  channel: ChannelId,
  purpose: String,
  ) extends ChannelOp[SlackResponse[String]]

final case class SetChannelTopic(
  token: OAuthToken,
  channel: ChannelId,
  topic: String,
  ) extends ChannelOp[SlackResponse[String]]

final case class UnarchiveChannel(
  token: OAuthToken,
  channel: ChannelId,
  ) extends ChannelOp[SlackResponse[Boolean]]


class ChannelOps[F[_]](implicit I: InjectK[ChannelOp, F]) {

  def archiveChannel(
                      token: OAuthToken,
                      channel: ChannelId,
                    ): Free[F, SlackResponse[Boolean]] = Free.inject[ChannelOp, F](
    ArchiveChannel(
      token,
      channel,
    )
  )

  def createChannel(
                     token: OAuthToken,
                     name: String,
                     validate: Option[Boolean] = None,
                   ): Free[F, SlackResponse[Channel]] = Free.inject[ChannelOp, F](
    CreateChannel(
      token,
      name,
      validate,
    )
  )

  def channelHistory(
                      token: OAuthToken,
                      channel: ChannelId,
                      count: Option[Int] = None,
                      inclusive: Option[Int] = None,
                      latest: Option[String] = None,
                      oldest: Option[String] = None,
                      unreads: Option[Boolean] = None,
                    ): Free[F, SlackResponse[Seq[ChannelHistory]]] = Free.inject[ChannelOp, F](GetChannelHistory(
    token,
    channel,
    count,
    inclusive,
    latest,
    oldest,
    unreads,
  ))

  def channelInfo(
                   token: OAuthToken,
                   channel: ChannelId,
                   includeLocale: Option[Boolean] = None,
                 ): Free[F, SlackResponse[Channel]] = Free.inject[ChannelOp, F](GetChannelInfo(
    token,
    channel,
    includeLocale,
  ))

  def channelInvite(
                     token: OAuthToken,
                     channel: ChannelId,
                     user: UserId,
                   ): Free[F, SlackResponse[Channel]] = Free.inject[ChannelOp, F](ChannelInvite(
    token,
    channel,
    user,
  ))

  def channelJoin(
                   token: OAuthToken,
                   name: String,
                   validate: Option[Boolean] = None,
                 ): Free[F, SlackResponse[Channel]] = Free.inject[ChannelOp, F](ChannelJoin(
    token,
    name,
    validate,
  ))

  def channelKick(
                   token: OAuthToken,
                   channel: ChannelId,
                   user: UserId,
                 ): Free[F, SlackResponse[Boolean]] = Free.inject[ChannelOp, F](ChannelKick(
    token,
    channel,
    user,
  ))

  def leaveChannel(
                    token: OAuthToken,
                    channel: ChannelId,
                  ): Free[F, SlackResponse[Boolean]] = Free.inject[ChannelOp, F](LeaveChannel(
    token,
    channel,
  ))

  def listChannels(
                    token: OAuthToken,
                    cursor: Option[String] = None,
                    excludeArchived: Option[Boolean] = None,
                    excludeMembers: Option[Boolean] = None,
                    limit: Option[Int] = None,
                  ): Free[F, SlackResponse[Seq[LimitedChannel]]] = Free.inject[ChannelOp, F](ListChannels(
    token,
    cursor,
    excludeArchived,
    excludeMembers,
    limit,
  ))

  def markChannel(
                   token: OAuthToken,
                   channel: ChannelId,
                   ts: UnixTimestamp,
                 ): Free[F, SlackResponse[Boolean]] = Free.inject[ChannelOp, F](MarkChannel(
    token,
    channel,
    ts,
  ))

  def renameChannel(
                     token: OAuthToken,
                     channel: ChannelId,
                     name: String,
                     validate: Option[Boolean] = None,
                   ): Free[F, SlackResponse[Channel]] = Free.inject[ChannelOp, F](RenameChannel(
    token,
    channel,
    name,
    validate,
  ))

  def channelReplies(
                      token: OAuthToken,
                      channel: ChannelId,
                      threadTs: UnixTimestamp,
                    ): Free[F, SlackResponse[Seq[RepliesChunk]]] = Free.inject[ChannelOp, F](GetChannelReplies(
    token,
    channel,
    threadTs,
  ))

  def channelPurpose(
                      token: OAuthToken,
                      channel: ChannelId,
                      purpose: String,
                    ): Free[F, SlackResponse[String]] = Free.inject[ChannelOp, F](SetChannelPurpose(
    token,
    channel,
    purpose,
  ))

  def channelTopic(
                    token: OAuthToken,
                    channel: ChannelId,
                    topic: String,
                  ): Free[F, SlackResponse[String]] = Free.inject[ChannelOp, F](SetChannelTopic(
    token,
    channel,
    topic,
  ))

  def unarchiveChannel(
                        token: OAuthToken,
                        channel: ChannelId,
                      ): Free[F, SlackResponse[Boolean]] = Free.inject[ChannelOp, F](UnarchiveChannel(
    token,
    channel,
  ))




}
