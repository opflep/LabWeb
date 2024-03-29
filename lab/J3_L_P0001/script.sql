USE [master]
GO
/****** Object:  Database [J3_L_P0001]    Script Date: 06/12/2018 13:33:19 ******/
CREATE DATABASE [J3_L_P0001] ON  PRIMARY 
( NAME = N'J3_L_P0001', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\J3_L_P0001.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'J3_L_P0001_log', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\J3_L_P0001_log.LDF' , SIZE = 512KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [J3_L_P0001] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3_L_P0001].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3_L_P0001] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [J3_L_P0001] SET ANSI_NULLS OFF
GO
ALTER DATABASE [J3_L_P0001] SET ANSI_PADDING OFF
GO
ALTER DATABASE [J3_L_P0001] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [J3_L_P0001] SET ARITHABORT OFF
GO
ALTER DATABASE [J3_L_P0001] SET AUTO_CLOSE ON
GO
ALTER DATABASE [J3_L_P0001] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [J3_L_P0001] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [J3_L_P0001] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [J3_L_P0001] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [J3_L_P0001] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [J3_L_P0001] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [J3_L_P0001] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [J3_L_P0001] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [J3_L_P0001] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [J3_L_P0001] SET  ENABLE_BROKER
GO
ALTER DATABASE [J3_L_P0001] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [J3_L_P0001] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [J3_L_P0001] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [J3_L_P0001] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [J3_L_P0001] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [J3_L_P0001] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [J3_L_P0001] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [J3_L_P0001] SET  READ_WRITE
GO
ALTER DATABASE [J3_L_P0001] SET RECOVERY SIMPLE
GO
ALTER DATABASE [J3_L_P0001] SET  MULTI_USER
GO
ALTER DATABASE [J3_L_P0001] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [J3_L_P0001] SET DB_CHAINING OFF
GO
USE [J3_L_P0001]
GO
/****** Object:  Table [dbo].[users]    Script Date: 06/12/2018 13:33:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NULL,
	[email] [varchar](20) NULL,
	[usertype] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[users] ([username], [password], [email], [usertype]) VALUES (N'ahihi', N'ahihihi', N'asdkj@gmail.com', 1)
INSERT [dbo].[users] ([username], [password], [email], [usertype]) VALUES (N'ahihihi', N'begoldtoad', N'asd', 1)
INSERT [dbo].[users] ([username], [password], [email], [usertype]) VALUES (N'asdz', N'asdasdasd', N'zxczxczxc', 0)
INSERT [dbo].[users] ([username], [password], [email], [usertype]) VALUES (N'sa', N'123456', N'vietnkse04597', 1)
INSERT [dbo].[users] ([username], [password], [email], [usertype]) VALUES (N'vietnk', N'123456', N'vietnkse04597', 0)
/****** Object:  Table [dbo].[quiz]    Script Date: 06/12/2018 13:33:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[quiz](
	[username] [varchar](20) NULL,
	[question] [varchar](200) NULL,
	[option1] [varchar](200) NULL,
	[isOption1True] [int] NULL,
	[option2] [varchar](200) NULL,
	[isOption2True] [int] NULL,
	[option3] [varchar](200) NULL,
	[isOption3True] [int] NULL,
	[option4] [varchar](200) NULL,
	[isOption4True] [int] NULL,
	[dataCreate] [varchar](200) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[quiz] ([username], [question], [option1], [isOption1True], [option2], [isOption2True], [option3], [isOption3True], [option4], [isOption4True], [dataCreate]) VALUES (N'sa', N'where is capital of japan', N'hanoi', 0, N'tokyo', 1, N'bangkok', 0, N'london', 0, N'12-Jun-2018')
INSERT [dbo].[quiz] ([username], [question], [option1], [isOption1True], [option2], [isOption2True], [option3], [isOption3True], [option4], [isOption4True], [dataCreate]) VALUES (N'sa', N'where is capital of thailand', N'hanoi', 0, N'tokyo', 0, N'bangkok', 1, N'london', 0, N'12-Jun-2018')
INSERT [dbo].[quiz] ([username], [question], [option1], [isOption1True], [option2], [isOption2True], [option3], [isOption3True], [option4], [isOption4True], [dataCreate]) VALUES (N'sa', N'where is capital of vietnam', N'hanoi', 1, N'tokyo', 0, N'bangkok', 0, N'london', 0, N'12-Jun-2018')
INSERT [dbo].[quiz] ([username], [question], [option1], [isOption1True], [option2], [isOption2True], [option3], [isOption3True], [option4], [isOption4True], [dataCreate]) VALUES (N'sa', N'where is capital of england', N'hanoi', 0, N'tokyo', 0, N'bangkok', 0, N'london', 1, N'12-Jun-2018')
INSERT [dbo].[quiz] ([username], [question], [option1], [isOption1True], [option2], [isOption2True], [option3], [isOption3True], [option4], [isOption4True], [dataCreate]) VALUES (N'sa', N'the football team dont participate wc 2018 is: ', N'brazil', 0, N'russia', 0, N'italia', 1, N'england', 0, N'12-Jun-2018')
INSERT [dbo].[quiz] ([username], [question], [option1], [isOption1True], [option2], [isOption2True], [option3], [isOption3True], [option4], [isOption4True], [dataCreate]) VALUES (N'sa', N'the world cup 2018 held at ', N'brazil', 0, N'russia', 1, N'spain', 0, N'england', 0, N'12-Jun-2018')
INSERT [dbo].[quiz] ([username], [question], [option1], [isOption1True], [option2], [isOption2True], [option3], [isOption3True], [option4], [isOption4True], [dataCreate]) VALUES (N'sa', N'how many team participate wc2018 ', N'16', 0, N'64', 0, N'32', 1, N'8', 0, N'12-Jun-2018')
/****** Object:  ForeignKey [FK__quiz__username__0519C6AF]    Script Date: 06/12/2018 13:33:22 ******/
ALTER TABLE [dbo].[quiz]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[users] ([username])
GO

select * from quiz