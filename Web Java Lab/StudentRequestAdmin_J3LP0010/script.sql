USE [master]
GO
/****** Object:  Database [StudentRequestAdmin]    Script Date: 8/15/2021 10:38:53 PM ******/
CREATE DATABASE [StudentRequestAdmin]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'StudentRequestAdmin', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\StudentRequestAdmin.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'StudentRequestAdmin_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\StudentRequestAdmin_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [StudentRequestAdmin] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [StudentRequestAdmin].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [StudentRequestAdmin] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET ARITHABORT OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [StudentRequestAdmin] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [StudentRequestAdmin] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET  ENABLE_BROKER 
GO
ALTER DATABASE [StudentRequestAdmin] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [StudentRequestAdmin] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET RECOVERY FULL 
GO
ALTER DATABASE [StudentRequestAdmin] SET  MULTI_USER 
GO
ALTER DATABASE [StudentRequestAdmin] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [StudentRequestAdmin] SET DB_CHAINING OFF 
GO
ALTER DATABASE [StudentRequestAdmin] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [StudentRequestAdmin] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [StudentRequestAdmin] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'StudentRequestAdmin', N'ON'
GO
USE [StudentRequestAdmin]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 8/15/2021 10:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[id] [int] NOT NULL,
	[name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Request]    Script Date: 8/15/2021 10:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[requestToDid] [int] NOT NULL,
	[studentID] [nvarchar](10) NULL,
	[dateCreated] [datetime] NOT NULL,
	[title] [nvarchar](300) NULL,
	[content] [nvarchar](200) NULL,
	[status] [int] NULL,
	[clodeDate] [datetime] NULL,
	[solvedBy] [nvarchar](100) NULL,
	[attachFile] [nvarchar](200) NULL,
	[solution] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 8/15/2021 10:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UserID] [nvarchar](10) NOT NULL,
	[username] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[fullName] [nvarchar](100) NOT NULL,
	[shortName] [nvarchar](50) NULL,
	[Role] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Department] ([id], [name]) VALUES (1, N'Academy department')
INSERT [dbo].[Department] ([id], [name]) VALUES (2, N'Development Department')
SET IDENTITY_INSERT [dbo].[Request] ON 

INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (23, 1, N'HE1', CAST(N'2021-07-19 00:00:00.000' AS DateTime), N'Check result PE', N'ninoinjakjshdashjkdjhas', 1, CAST(N'2021-07-21 17:40:18.263' AS DateTime), N'admin', N'a.txt', N'School agrees to your request!!!')
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (25, 2, N'HE1', CAST(N'2021-07-19 00:00:00.000' AS DateTime), N'Check result FE', N'please check cho em', 1, CAST(N'2021-07-19 16:41:44.320' AS DateTime), N'admin', N'b.txt', N'School agrees to your request!!!')
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (26, 2, N'HE2', CAST(N'2021-07-19 00:00:00.000' AS DateTime), N'Check result FE', N'please check cho em', 1, CAST(N'2021-07-21 17:40:27.147' AS DateTime), N'admin', N'data.txt', N'School agrees to your request!!!')
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (27, 1, N'HE3', CAST(N'2021-07-19 00:00:00.000' AS DateTime), N'Check result FE', N'please check cho em', 2, CAST(N'2021-07-19 16:41:20.563' AS DateTime), N'admin', N'data.txt', N'School agrees to your request!!!')
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (28, 1, N'HE3', CAST(N'2021-07-18 00:00:00.000' AS DateTime), N'Check result FE', N'please check cho em', NULL, NULL, NULL, N'data.txt', NULL)
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (31, 2, N'HE1', CAST(N'2021-07-18 00:00:00.000' AS DateTime), N'Check result PE Sum2021', N'please check lai diem PE cho em', NULL, NULL, NULL, N'b.txt', NULL)
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (32, 1, N'HE2', CAST(N'2021-07-18 00:00:00.000' AS DateTime), N'Check result PE Sum2021', N'please check lai diem PE cho em', NULL, NULL, NULL, N'b.txt', NULL)
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (33, 2, N'HE3', CAST(N'2021-07-18 00:00:00.000' AS DateTime), N'Check result FE Sum2021', N'please check my FE exam Sum2021', NULL, NULL, NULL, N'data.txt', NULL)
INSERT [dbo].[Request] ([id], [requestToDid], [studentID], [dateCreated], [title], [content], [status], [clodeDate], [solvedBy], [attachFile], [solution]) VALUES (34, 1, N'HE1', CAST(N'2021-07-18 00:00:00.000' AS DateTime), N'Check result FE Sum2021', N'please check my FE exam Sum2021', NULL, NULL, NULL, N'b.txt', NULL)
SET IDENTITY_INSERT [dbo].[Request] OFF
INSERT [dbo].[User] ([UserID], [username], [password], [fullName], [shortName], [Role]) VALUES (N'admin', N'admin', N'123', N'admin', N'admin', 1)
INSERT [dbo].[User] ([UserID], [username], [password], [fullName], [shortName], [Role]) VALUES (N'HE1', N'sonnc', N'123', N'Nguyen Cong Son', N'SonNC', 0)
INSERT [dbo].[User] ([UserID], [username], [password], [fullName], [shortName], [Role]) VALUES (N'HE2', N'honghh', N'123', N'Hoang Hoa Hong', N'HongHH', 0)
INSERT [dbo].[User] ([UserID], [username], [password], [fullName], [shortName], [Role]) VALUES (N'HE3', N'anhnt', N'123', N'Nguyen The Anh', N'AnhNT', 0)
ALTER TABLE [dbo].[Request]  WITH CHECK ADD FOREIGN KEY([requestToDid])
REFERENCES [dbo].[Department] ([id])
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD FOREIGN KEY([studentID])
REFERENCES [dbo].[User] ([UserID])
GO
USE [master]
GO
ALTER DATABASE [StudentRequestAdmin] SET  READ_WRITE 
GO
