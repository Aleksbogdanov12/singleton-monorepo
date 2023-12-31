﻿/*
 * Copyright 2020-2021 VMware, Inc.
 * SPDX-License-Identifier: EPL-2.0
 */

using System;

namespace SingletonClient.Implementation.Support
{
    /// <summary>
    /// Interface for base io functions.
    /// </summary>
    public interface ISingletonBaseIo
    {
        /// <summary>
        /// Write line in console.
        /// </summary>
        /// <param name="text"></param>
        void ConsoleWriteLine(string text);
    }

    public class SingletonBaseIo : ISingletonBaseIo
    {
        private static ISingletonBaseIo _instance = new SingletonBaseIo();

        public static ISingletonBaseIo GetInstance()
        {
            return _instance;
        }

        public static void SetInstance(ISingletonBaseIo instance)
        {
            _instance = instance;
        }

        /// <summary>
        /// ISingletonBaseIo
        /// </summary>
        public void ConsoleWriteLine(string text)
        {
            Console.WriteLine(text);
        }
    }
}
